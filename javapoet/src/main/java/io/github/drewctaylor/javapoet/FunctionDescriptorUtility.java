package io.github.drewctaylor.javapoet;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeVariableName;
import io.github.drewctaylor.require.Require;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public static JavaFile javaFile(
            final FunctionDescriptor descriptor)
    {
        final TypeSpec.Builder builder = TypeSpec
                .interfaceBuilder(descriptor.getClassName().simpleName())
                .addModifiers(PUBLIC)
                .addTypeVariables(descriptor.getTypeVariableNameList())
                .addMethod(f(descriptor))
                .addMethod(fN(descriptor));

        p(descriptor).ifPresent(builder::addMethod);
        e(descriptor).ifPresent(builder::addMethod);

        return JavaFile
                .builder(descriptor.getClassName().packageName(), builder.build())
                .skipJavaLangImports(true)
                .addStaticImport(Require.class, "requireNonNull")
                .build();
    }

    private static MethodSpec f(
            final FunctionDescriptor descriptor)
    {
        final MethodSpec.Builder builder = MethodSpec
                .methodBuilder("f")
                .addModifiers(PUBLIC, ABSTRACT)
                .addParameters(
                        descriptor
                                .getParameterList()
                                .stream()
                                .map(FunctionDescriptorUtility::parameterSpec)
                                .collect(toList()));

        descriptor.getExceptionOptional().ifPresent(builder::addException);
        descriptor.getReturnOptional().ifPresent(builder::returns);

        return builder.build();
    }

    private static MethodSpec fN(
            final FunctionDescriptor descriptor)
    {
        final ParameterSpec parameterSpec = descriptor.getParameterSpec();

        return MethodSpec
                .methodBuilder(descriptor.getClassName().simpleName().toLowerCase())
                .addModifiers(PUBLIC, STATIC)
                .addTypeVariables(descriptor.getTypeVariableNameList())
                .returns(descriptor.getTypeName())
                .addParameter(parameterSpec)
                .addStatement(
                        "$T.requireNonNull($N, \"$N\")",
                        Require.class,
                        parameterSpec.name,
                        parameterSpec.name)
                .addStatement(
                        "return $N",
                        parameterSpec.name)
                .build();
    }

    private static Optional<MethodSpec> p(
            final FunctionDescriptor descriptor)
    {
        final String parameterList1 = parameterList(descriptor.getParameterList().stream().skip(1));
        final String parameterList2 = parameterList(descriptor.getParameterList().stream());

        return descriptor.getParameterList().stream().findFirst().map(parameter -> MethodSpec
                .methodBuilder("p")
                .addModifiers(PUBLIC, DEFAULT)
                .returns(descriptor.getTypeNameOther().get())
                .addParameter(parameterSpec(parameter))
                .addStatement(format("return (%s) -> f(%s)", parameterList1, parameterList2))
                .build());
    }

    private static Optional<MethodSpec> e(
            final FunctionDescriptor descriptor)
    {
        return descriptor.getExceptionOptional().map(exception ->
        {
            final ParameterSpec parameterSpec = parameterSpec(exception);
            final String parameterList = parameterList(descriptor.getParameterList().stream());

            return MethodSpec
                    .methodBuilder("e")
                    .addModifiers(PUBLIC, STATIC)
                    .addTypeVariables(descriptor.getTypeVariableNameList())
                    .returns(descriptor.getTypeName())
                    .addParameter(parameterSpec)
                    .addStatement(
                            "$T.requireNonNull($N, \"$N\")",
                            Require.class,
                            parameterSpec.name,
                            parameterSpec.name)
                    .addStatement(format("return (%s) -> { throw $N; }", parameterList), parameterSpec.name)
                    .build();
        });
    }

    private static ParameterSpec parameterSpec(
            final TypeVariableName typeVariableName)
    {
        return ParameterSpec.builder(typeVariableName, typeVariableName.name.toLowerCase(), FINAL).build();
    }

    private static String parameterList(
            final Stream<TypeVariableName> typeVariableNameStream)
    {
        return typeVariableNameStream.map(typeVariableName -> typeVariableName.name.toLowerCase()).collect(Collectors.joining(", "));
    }
}