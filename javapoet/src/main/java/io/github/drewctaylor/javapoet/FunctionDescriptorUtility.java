package io.github.drewctaylor.javapoet;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeVariableName;
import io.github.drewctaylor.require.Require;

import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.squareup.javapoet.MethodSpec.methodBuilder;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;
import static javax.lang.model.element.Modifier.ABSTRACT;
import static javax.lang.model.element.Modifier.DEFAULT;
import static javax.lang.model.element.Modifier.FINAL;
import static javax.lang.model.element.Modifier.PUBLIC;
import static javax.lang.model.element.Modifier.STATIC;

public final class FunctionDescriptorUtility
{
    private FunctionDescriptorUtility()
    {
    }

    /**
     * Given a function descriptor, return a java file.
     *
     * @param  functionDescriptor the function descriptor
     *
     * @return                    the java file
     */
    public static JavaFile javaFile(
            final FunctionDescriptor functionDescriptor)
    {
        final TypeSpec.Builder builder = TypeSpec
                .interfaceBuilder(functionDescriptor.getClassName().simpleName())
                .addAnnotation(FunctionalInterface.class)
                .addModifiers(PUBLIC)
                .addTypeVariables(functionDescriptor.getTypeVariableNameList())
                .addMethod(f(functionDescriptor))
                .addMethod(constructor(functionDescriptor))
                .addMethod(constant(functionDescriptor, "constant", "c"));

        System.out.println(functionDescriptor.getTypeNameForCurry());

        argument(functionDescriptor, "argument", "a").ifPresent(builder::addMethod);
        exception(functionDescriptor, "exception", "e").ifPresent(builder::addMethod);
        identity(functionDescriptor, "identity", "id").ifPresent(builder::addMethod);

        return JavaFile
                .builder(functionDescriptor.getClassName().packageName(), builder.build())
                .skipJavaLangImports(true)
                .addStaticImport(Require.class, "requireNonNull")
                .build();
    }

    /**
     * Given a function descriptor, return a method spec.
     *
     * @param  functionDescriptor the function descriptor
     *
     * @return                    the method spec
     */
    private static MethodSpec f(
            final FunctionDescriptor functionDescriptor)
    {
        final MethodSpec.Builder builder = methodBuilder("f")
                .addModifiers(PUBLIC, ABSTRACT)
                .addParameters(
                        functionDescriptor
                                .getParameterList()
                                .stream()
                                .map(FunctionDescriptorUtility::parameterSpec)
                                .collect(toList()));

        functionDescriptor.getExceptionOptional().ifPresent(builder::addException);
        functionDescriptor.getReturnOptional().ifPresent(builder::returns);

        return builder.build();
    }

    /**
     * Given a function descriptor, return a method spec for the constant method.
     *
     * @param  functionDescriptor the function descriptor
     *
     * @return                    the method spec for the constant method
     */
    private static MethodSpec constructor(
            final FunctionDescriptor functionDescriptor)
    {
        return methodBuilder(functionDescriptor.getClassName().simpleName().toLowerCase(Locale.ENGLISH))
                .addModifiers(PUBLIC, STATIC)
                .addTypeVariables(functionDescriptor.getTypeVariableNameList())
                .returns(functionDescriptor.getTypeName())
                .addParameter(functionDescriptor.getParameterSpec())
                .addStatement(
                        "$T.requireNonNull($N, \"$N\")",
                        Require.class,
                        functionDescriptor.getParameterSpec().name,
                        functionDescriptor.getParameterSpec().name)
                .addStatement(
                        "return $N",
                        functionDescriptor.getParameterSpec().name)
                .build();
    }

    private static Optional<MethodSpec> argument(
            final FunctionDescriptor descriptor,
            final String callee,
            final String... callerArray)
    {
        return descriptor.getTypeNameForArgument().flatMap(typeNameForArgument -> descriptor.getParameterList().stream().findFirst().map(parameter -> methodBuilder(callee)
                .addModifiers(PUBLIC, DEFAULT)
                .returns(typeNameForArgument)
                .addParameter(parameterSpec(parameter))
                .addStatement(
                        format(
                                "return (%s) -> f(%s)",
                                parameterList(descriptor.getParameterList().stream().skip(1)),
                                parameterList(descriptor.getParameterList().stream())))
                .build()));
    }

    private static Optional<MethodSpec> exception(
            final FunctionDescriptor descriptor,
            final String callee,
            final String... callerArray)
    {
        return descriptor.getExceptionOptional()
                .map(exception -> methodBuilder(callee)
                        .addModifiers(PUBLIC, STATIC)
                        .addTypeVariables(descriptor.getTypeVariableNameList())
                        .returns(descriptor.getTypeName())
                        .addParameter(parameterSpec(exception))
                        .addStatement(
                                "$T.requireNonNull($N, \"$N\")",
                                Require.class,
                                parameterSpec(exception).name,
                                parameterSpec(exception).name)
                        .addStatement(
                                format(
                                        "return (%s) -> { throw $N; }",
                                        parameterList(descriptor.getParameterList().stream())),
                                parameterSpec(exception).name)
                        .build());
    }

    private static MethodSpec constant(
            final FunctionDescriptor descriptor,
            final String callee,
            final String... callerArray)
    {
        return descriptor.getReturnOptional()
                .map(returnType -> methodBuilder(callee)
                        .addModifiers(PUBLIC, STATIC)
                        .addTypeVariables(descriptor.getTypeVariableNameList())
                        .returns(descriptor.getTypeName())
                        .addParameter(parameterSpec(returnType))
                        .addStatement(
                                format(
                                        "return (%s) -> $N",
                                        parameterList(descriptor.getParameterList().stream())),
                                parameterSpec(returnType).name)
                        .build())
                .orElse(methodBuilder(callee)
                        .addModifiers(PUBLIC, STATIC)
                        .addTypeVariables(descriptor.getTypeVariableNameList())
                        .returns(descriptor.getTypeName())
                        .addStatement(
                                format(
                                        "return (%s) -> { }",
                                        parameterList(descriptor.getParameterList().stream())))
                        .build());
    }

    private static Optional<MethodSpec> identity(
            final FunctionDescriptor descriptor,
            final String callee,
            final String... callerArray)
    {
        return descriptor.getReturnOptional().flatMap(returnType -> descriptor.getParameterList().stream().findFirst().map(parameter ->
        {
            final FunctionDescriptor descriptorInner = new FunctionDescriptor(
                    descriptor.getClassName().packageName(),
                    descriptor.getParameterList().size(),
                    Optional.of(parameter),
                    descriptor.getExceptionOptional());

            return methodBuilder(callee)
                    .addModifiers(PUBLIC, STATIC)
                    .addTypeVariables(Stream.concat(descriptorInner.getParameterList().stream(), descriptorInner.getExceptionOptional().map(Stream::of).orElseGet(Stream::empty)).collect(toList()))
                    .returns(descriptorInner.getTypeName())
                    .addStatement(format("return (%s) -> $N", parameterList(descriptorInner.getParameterList().stream())), parameterSpec(parameter).name)
                    .build();
        }));
    }

    /**
     * Given a type variable name, return a parameter spec.
     *
     * @param  typeVariableName the type variable name
     *
     * @return                  the parameter spec
     */
    private static ParameterSpec parameterSpec(
            final TypeVariableName typeVariableName)
    {
        return ParameterSpec.builder(typeVariableName, typeVariableName.name.toLowerCase(Locale.ENGLISH), FINAL).build();
    }

    /**
     * Given a type variable name stream, return a parameter list.
     *
     * @param  typeVariableNameStream the type variable name stream
     *
     * @return                        the parameter list
     */
    private static String parameterList(
            final Stream<TypeVariableName> typeVariableNameStream)
    {
        return typeVariableNameStream.map(typeVariableName -> typeVariableName.name.toLowerCase(Locale.ENGLISH)).collect(Collectors.joining(", "));
    }
}