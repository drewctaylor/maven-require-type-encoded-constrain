package io.github.drewctaylor.javapoet.function;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import io.github.drewctaylor.require.Require;

import java.util.function.Function;

import static io.github.drewctaylor.javapoet.JavaPoetUtility.apply;
import static io.github.drewctaylor.javapoet.JavaPoetUtility.c;
import static io.github.drewctaylor.javapoet.JavaPoetUtility.curry;
import static io.github.drewctaylor.javapoet.JavaPoetUtility.e;
import static io.github.drewctaylor.javapoet.JavaPoetUtility.f;
import static io.github.drewctaylor.javapoet.JavaPoetUtility.fN;
import static io.github.drewctaylor.javapoet.JavaPoetUtility.methodSpec;
import static io.github.drewctaylor.javapoet.JavaPoetUtility.reverse;
import static io.github.drewctaylor.javapoet.JavaPoetUtility.superInterface;
import static io.github.drewctaylor.javapoet.JavaPoetUtility.then;
import static io.github.drewctaylor.javapoet.JavaPoetUtility.typeVariableNameJavadocList;
import static io.github.drewctaylor.javapoet.JavaPoetUtility.typeVariableNameList;
import static io.github.drewctaylor.javapoet.JavaPoetUtility.typeVariableNameR;
import static io.github.drewctaylor.javapoet.JavaPoetUtility.uncurry;
import static io.github.drewctaylor.require.RequireNumberInteger.requireInteger;
import static io.github.drewctaylor.require.RequireNumberInteger.requireZeroOrPositive;
import static java.lang.String.format;
import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;
import static java.util.stream.Stream.concat;
import static java.util.stream.Stream.of;
import static javax.lang.model.element.Modifier.PUBLIC;

/**
 * Returns java files that implement functions - F0 through Fn, where n is the parameter count.
 */
public final class FunctionFactory
{
    private FunctionFactory()
    {
    }

    /**
     * Returns java files that implement functions - F0 through Fn, where n is the parameter count.
     *
     * @param parameterCountString the parameter count
     * @return java source that implement functions - F0 through Fn, where n is the parameter count
     * @throws NullPointerException     if parameterCountString is null
     * @throws IllegalArgumentException if parameterCountString is empty
     * @throws IllegalArgumentException if parameterCountString is not an int
     * @throws IllegalArgumentException if parameterCountString is not zero or positive
     */
    public static Iterable<JavaFile> iterable(
            final String parameterCountString)
    {
        final int parameterCountInteger = requireInteger(parameterCountString, "parameterCountString");
        final int parameterCount = requireZeroOrPositive(parameterCountInteger, "parameterCountInteger");

        return range(0, parameterCount + 1)
                .mapToObj(FunctionDescriptor::new)
                .map(FunctionFactory::javaFile)
                .collect(toList());
    }

    private static JavaFile javaFile(
            final FunctionDescriptor descriptor)
    {
        final ClassName className = descriptor.getClassName();

        final Function<TypeSpec.Builder, TypeSpec.Builder> typeSpecBuilderAddMethodByEffect = builder ->
                !descriptor.getTypeVariableNameForReturn().isPresent() ?
                        builder :
                        builder
                                .addMethod(then(descriptor))
                                .addMethods(c(descriptor).collect(toList()));

        final Function<TypeSpec.Builder, TypeSpec.Builder> typeSpecBuilderAddMethodByException = builder ->
                descriptor.getTypeVariableNameForException().isPresent() ?
                        builder.addMethod(e(descriptor.getParameterCount(), !descriptor.getTypeVariableNameForReturn().isPresent())) :
                        builder;

        final Function<TypeSpec.Builder, TypeSpec.Builder> typeSpecBuilderAddMethodByParameterCount = builder ->
                descriptor.getParameterCount() == 0 ?
                        !descriptor.getTypeVariableNameForReturn().isPresent() ?
                                builder
                                        .addMethods(c(descriptor.getParameterCount(), descriptor.getTypeVariableNameForException().isPresent(), !descriptor.getTypeVariableNameForReturn().isPresent()).collect(toList())) :
                                builder :
                        descriptor.getParameterCount() == 1 ?
                                builder
                                        .addMethods(c(descriptor.getParameterCount(), descriptor.getTypeVariableNameForException().isPresent(), !descriptor.getTypeVariableNameForReturn().isPresent()).collect(toList()))
                                        .addMethod(apply(descriptor.getParameterCount(), descriptor.getTypeVariableNameForException().isPresent(), !descriptor.getTypeVariableNameForReturn().isPresent())) :
                                builder
                                        .addMethods(c(descriptor.getParameterCount(), descriptor.getTypeVariableNameForException().isPresent(), !descriptor.getTypeVariableNameForReturn().isPresent()).collect(toList()))
                                        .addMethod(apply(descriptor.getParameterCount(), descriptor.getTypeVariableNameForException().isPresent(), !descriptor.getTypeVariableNameForReturn().isPresent()))
                                        .addMethod(reverse(descriptor.getParameterCount(), descriptor.getTypeVariableNameForException().isPresent(), !descriptor.getTypeVariableNameForReturn().isPresent()))
                                        .addMethod(curry(descriptor.getParameterCount(), descriptor.getTypeVariableNameForException().isPresent(), !descriptor.getTypeVariableNameForReturn().isPresent()))
                                        .addMethod(uncurry(descriptor.getParameterCount(), descriptor.getTypeVariableNameForException().isPresent(), !descriptor.getTypeVariableNameForReturn().isPresent()));

        final String javadoc = concat(
                of(format("A %s-parameter %s%s.", descriptor.getParameterCount(), !descriptor.getTypeVariableNameForReturn().isPresent() ? "effect" : "function", descriptor.getTypeVariableNameForException().isPresent() ? " that may throw an exception" : "")),
                typeVariableNameJavadocList(0, descriptor.getParameterCount(), typeVariableNameR(1), descriptor.getTypeVariableNameForException().isPresent(), !descriptor.getTypeVariableNameForReturn().isPresent()))
                .collect(joining(lineSeparator()));

        return JavaFile.builder(
                        className.packageName(),
                        typeSpecBuilderAddMethodByException
                                .apply(typeSpecBuilderAddMethodByEffect
                                        .apply(typeSpecBuilderAddMethodByParameterCount
                                                .apply(TypeSpec
                                                        .interfaceBuilder(className.simpleName())
                                                        .addJavadoc(javadoc)
                                                        .addAnnotation(FunctionalInterface.class)
                                                        .addModifiers(PUBLIC)
                                                        .addTypeVariables(typeVariableNameList(0, descriptor.getParameterCount(), typeVariableNameR(1), descriptor.getTypeVariableNameForException().isPresent(), !descriptor.getTypeVariableNameForReturn().isPresent()).collect(toList()))
                                                        .addSuperinterfaces(superInterface(descriptor.getParameterCount(), descriptor.getTypeVariableNameForException().isPresent(), !descriptor.getTypeVariableNameForReturn().isPresent()).collect(toList()))
                                                        .addMethod(f(descriptor.getParameterCount(), descriptor.getTypeVariableNameForException().isPresent(), !descriptor.getTypeVariableNameForReturn().isPresent()))
                                                        .addMethod(fN(descriptor.getParameterCount(), descriptor.getTypeVariableNameForException().isPresent(), !descriptor.getTypeVariableNameForReturn().isPresent())))))
                                .addMethods(methodSpec(descriptor.getParameterCount(), descriptor.getTypeVariableNameForException().isPresent(), !descriptor.getTypeVariableNameForReturn().isPresent()).collect(toList()))
                                .build())
                .skipJavaLangImports(true)
                .addStaticImport(Require.class, "requireNonNull")
                .build();
    }

}