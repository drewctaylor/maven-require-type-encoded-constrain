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
                .addAnnotation(FunctionalInterface.class)
                .addModifiers(PUBLIC)
                .addTypeVariables(descriptor.getTypeVariableNameList())
                .addMethod(f(descriptor))
                .addMethod(constructor(descriptor))
                .addMethod(constant(descriptor));

        parameter(descriptor).ifPresent(builder::addMethod);
        exception(descriptor).ifPresent(builder::addMethod);
        identity(descriptor).ifPresent(builder::addMethod);

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

    private static MethodSpec constructor(
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

    private static Optional<MethodSpec> parameter(
            final FunctionDescriptor descriptor)
    {
        final String parameterList1 = parameterList(descriptor.getParameterList().stream().skip(1));
        final String parameterList2 = parameterList(descriptor.getParameterList().stream());

        return descriptor.getParameterList().stream().findFirst().map(parameter -> MethodSpec
                .methodBuilder("parameter")
                .addModifiers(PUBLIC, DEFAULT)
                .returns(descriptor.getTypeNameOther().get())
                .addParameter(parameterSpec(parameter))
                .addStatement(format("return (%s) -> f(%s)", parameterList1, parameterList2))
                .build());
    }

    private static Optional<MethodSpec> exception(
            final FunctionDescriptor descriptor)
    {
        return descriptor.getExceptionOptional().map(exception ->
        {
            final ParameterSpec parameterSpec = parameterSpec(exception);
            final String parameterList = parameterList(descriptor.getParameterList().stream());

            return MethodSpec
                    .methodBuilder("exception")
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

    private static MethodSpec constant(
            final FunctionDescriptor descriptor)
    {
        return descriptor.getReturnOptional()
                .map(returnType ->
                {
                    final ParameterSpec parameterSpec = parameterSpec(returnType);
                    final String parameterList = parameterList(descriptor.getParameterList().stream());

                    return MethodSpec
                            .methodBuilder("constant")
                            .addModifiers(PUBLIC, STATIC)
                            .addTypeVariables(descriptor.getTypeVariableNameList())
                            .returns(descriptor.getTypeName())
                            .addParameter(parameterSpec)
                            .addStatement(format("return (%s) -> $N", parameterList), parameterSpec.name)
                            .build();
                })
                .orElseGet(() ->
                {
                    final String parameterList = parameterList(descriptor.getParameterList().stream());

                    return MethodSpec
                            .methodBuilder("nothing")
                            .addModifiers(PUBLIC, STATIC)
                            .addTypeVariables(descriptor.getTypeVariableNameList())
                            .returns(descriptor.getTypeName())
                            .addStatement(format("return (%s) -> { }", parameterList))
                            .build();
                });
    }

    private static Optional<MethodSpec> identity(
            final FunctionDescriptor descriptor)
    {
        return descriptor.getReturnOptional().flatMap(returnType -> descriptor.getParameterList().stream().findFirst().map(parameter ->
        {
            final FunctionDescriptor descriptorInner = new FunctionDescriptor(
                    descriptor.getClassName().packageName(),
                    descriptor.getParameterList().size(),
                    Optional.of(parameter),
                    descriptor.getExceptionOptional());

            final ParameterSpec parameterSpec = parameterSpec(parameter);
            final String parameterList = parameterList(descriptorInner.getParameterList().stream());

            return MethodSpec
                    .methodBuilder("identity")
                    .addModifiers(PUBLIC, STATIC)
                    .addTypeVariables(Stream.concat(descriptorInner.getParameterList().stream(), descriptorInner.getExceptionOptional().map(Stream::of).orElseGet(Stream::empty)).collect(toList()))
                    .returns(descriptorInner.getTypeName())
                    .addStatement(format("return (%s) -> $N", parameterList), parameterSpec.name)
                    .build();
        }));
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