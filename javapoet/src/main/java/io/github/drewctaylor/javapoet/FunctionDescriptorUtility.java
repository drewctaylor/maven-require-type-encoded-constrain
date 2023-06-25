package io.github.drewctaylor.javapoet;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeVariableName;
import io.github.drewctaylor.require.Require;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import static io.github.drewctaylor.javapoet.JavaPoetUtility.parameterList;
import static io.github.drewctaylor.javapoet.JavaPoetUtility.parameterSpec;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;
import static javax.lang.model.element.Modifier.ABSTRACT;
import static javax.lang.model.element.Modifier.DEFAULT;
import static javax.lang.model.element.Modifier.PUBLIC;
import static javax.lang.model.element.Modifier.STATIC;

/**
 *
 */
public final class FunctionDescriptorUtility
{
    private FunctionDescriptorUtility()
    {
    }

    /**
     *
     */
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
                .addMethod(constant(descriptor, "constant", "c"));

        superInterface(descriptor).ifPresent(builder::addSuperinterface);
        superInterfaceMethodSpec(descriptor).ifPresent(builder::addMethod);
        argument(descriptor, "argument", "a").ifPresent(builder::addMethod);
        exception(descriptor, "exception", "e").ifPresent(builder::addMethod);
        identity(descriptor, "identity", "id").ifPresent(builder::addMethod);

        return JavaFile
                .builder(descriptor.getClassName().packageName(), builder.build())
                .skipJavaLangImports(true)
                .addStaticImport(Require.class, "requireNonNull")
                .build();
    }

    private static Optional<ParameterizedTypeName> superInterface(
            final FunctionDescriptor descriptor)
    {
        final Function<TypeVariableName, ParameterizedTypeName> supplierFor = returnType -> ParameterizedTypeName.get(ClassName.get("java.util.function", "Supplier"), returnType);
        final Function<TypeVariableName, Function<TypeVariableName, ParameterizedTypeName>> functionFor = parameterType1 -> returnType -> ParameterizedTypeName.get(ClassName.get("java.util.function", "Function"), parameterType1, returnType);
        final Function<TypeVariableName, Function<TypeVariableName, Function<TypeVariableName, ParameterizedTypeName>>> biFunctionFor = parameterType1 -> parameterType2 -> returnType -> ParameterizedTypeName.get(ClassName.get("java.util.function", "BiFunction"), parameterType1, parameterType2, returnType);
        final Function<TypeVariableName, ParameterizedTypeName> consumerFor = parameterType1 -> ParameterizedTypeName.get(ClassName.get("java.util.function", "Consumer"), parameterType1);
        final Function<TypeVariableName, Function<TypeVariableName, ParameterizedTypeName>> biConsumerFor = parameterType1 -> parameterType2 -> ParameterizedTypeName.get(ClassName.get("java.util.function", "BiConsumer"), parameterType1, parameterType2);

        return superInterfaceHelper(descriptor, supplierFor, functionFor, biFunctionFor, consumerFor, biConsumerFor);
    }

    private static Optional<MethodSpec> superInterfaceMethodSpec(
            final FunctionDescriptor descriptor)
    {
        final Function<TypeVariableName, MethodSpec> forSupplier = returnType -> MethodSpec
                .methodBuilder("get")
                .addAnnotation(Override.class)
                .addModifiers(PUBLIC, DEFAULT)
                .returns(returnType)
                .addStatement("return f()")
                .build();

        final Function<TypeVariableName, Function<TypeVariableName, MethodSpec>> forFunction = parameterType1 -> returnType -> MethodSpec
                .methodBuilder("apply")
                .addAnnotation(Override.class)
                .addModifiers(PUBLIC, DEFAULT)
                .returns(returnType)
                .addParameter(parameterSpec(parameterType1))
                .addStatement("return f($N)", parameterSpec(parameterType1).name)
                .build();

        final Function<TypeVariableName, Function<TypeVariableName, Function<TypeVariableName, MethodSpec>>> forBiFunction = parameterType1 -> parameterType2 -> returnType -> MethodSpec
                .methodBuilder("apply")
                .addAnnotation(Override.class)
                .addModifiers(PUBLIC, DEFAULT)
                .returns(returnType)
                .addParameter(parameterSpec(parameterType1))
                .addParameter(parameterSpec(parameterType2))
                .addStatement("return f($N, $N)", parameterSpec(parameterType1).name, parameterSpec(parameterType2).name)
                .build();

        final Function<TypeVariableName, MethodSpec> forConsumer = parameterType1 -> MethodSpec
                .methodBuilder("accept")
                .addAnnotation(Override.class)
                .addModifiers(PUBLIC, DEFAULT)
                .addParameter(parameterSpec(parameterType1))
                .addStatement("f($N)", parameterSpec(parameterType1).name)
                .build();

        final Function<TypeVariableName, Function<TypeVariableName, MethodSpec>> forBiConsumer = parameterType1 -> parameterType2 -> MethodSpec
                .methodBuilder("accept")
                .addAnnotation(Override.class)
                .addModifiers(PUBLIC, DEFAULT)
                .addParameter(parameterSpec(parameterType1))
                .addParameter(parameterSpec(parameterType2))
                .addStatement("f($N, $N)", parameterSpec(parameterType1).name, parameterSpec(parameterType2).name)
                .build();

        return superInterfaceHelper(descriptor, forSupplier, forFunction, forBiFunction, forConsumer, forBiConsumer);
    }

    private static <T> Optional<T> superInterfaceHelper(
            final FunctionDescriptor descriptor,
            final Function<TypeVariableName, T> forSupplier,
            final Function<TypeVariableName, Function<TypeVariableName, T>> forFunction,
            final Function<TypeVariableName, Function<TypeVariableName, Function<TypeVariableName, T>>> forBiFunction,
            final Function<TypeVariableName, T> forConsumer,
            final Function<TypeVariableName, Function<TypeVariableName, T>> forBiConsumer)
    {
        return descriptor.getExceptionOptional()
                .map(exceptionType -> Optional.<T>empty())
                .orElse(descriptor.getReturnOptional()
                        .map(returnType -> descriptor.getParameterList().isEmpty() ?
                                Optional.ofNullable(forSupplier.apply(returnType)) :
                                descriptor.getParameterList().size() == 1 ?
                                        Optional.ofNullable(forFunction.apply(descriptor.getParameterList().get(0)).apply(returnType)) :
                                        descriptor.getParameterList().size() == 2 ?
                                                Optional.ofNullable(forBiFunction.apply(descriptor.getParameterList().get(0)).apply(descriptor.getParameterList().get(1)).apply(returnType)) :
                                                Optional.<T>empty())
                        .orElse(descriptor.getParameterList().size() == 1 ?
                                Optional.ofNullable(forConsumer.apply(descriptor.getParameterList().get(0))) :
                                descriptor.getParameterList().size() == 2 ?
                                        Optional.ofNullable(forBiConsumer.apply(descriptor.getParameterList().get(0)).apply(descriptor.getParameterList().get(1))) :
                                        Optional.empty()));
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
                                .map(JavaPoetUtility::parameterSpec)
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

    private static Optional<MethodSpec> argument(
            final FunctionDescriptor descriptor,
            final String name,
            final String... nameArray)
    {
        return descriptor.getTypeNameForArgument().flatMap(typeNameForArgument -> descriptor.getParameterList().stream().findFirst().map(parameter -> MethodSpec
                .methodBuilder(name)
                .addModifiers(PUBLIC, DEFAULT)
                .returns(typeNameForArgument)
                .addParameter(parameterSpec(parameter))
                .addStatement(format("return (%s) -> f(%s)", parameterList(descriptor.getParameterList().stream().skip(1)), parameterList(descriptor.getParameterList().stream())))
                .build()));
    }

    private static Optional<MethodSpec> exception(
            final FunctionDescriptor descriptor,
            final String name,
            final String... nameArray)
    {
        return descriptor.getExceptionOptional()
                .map(exception -> MethodSpec
                        .methodBuilder(name)
                        .addModifiers(PUBLIC, STATIC)
                        .addTypeVariables(descriptor.getTypeVariableNameList())
                        .returns(descriptor.getTypeName())
                        .addParameter(parameterSpec(exception))
                        .addStatement(
                                "$T.requireNonNull($N, \"$N\")",
                                Require.class,
                                parameterSpec(exception).name,
                                parameterSpec(exception).name)
                        .addStatement(format("return (%s) -> { throw $N; }", parameterList(descriptor.getParameterList())), parameterSpec(exception).name)
                        .build());
    }

    private static MethodSpec constant(
            final FunctionDescriptor descriptor,
            final String name,
            final String... nameArray)
    {
        return descriptor.getReturnOptional()
                .map(returnType -> MethodSpec
                        .methodBuilder(name)
                        .addModifiers(PUBLIC, STATIC)
                        .addTypeVariables(descriptor.getTypeVariableNameList())
                        .returns(descriptor.getTypeName())
                        .addParameter(parameterSpec(returnType))
                        .addStatement(format("return (%s) -> $N", parameterList(descriptor.getParameterList())), parameterSpec(returnType).name)
                        .build())
                .orElse(MethodSpec
                        .methodBuilder(name)
                        .addModifiers(PUBLIC, STATIC)
                        .addTypeVariables(descriptor.getTypeVariableNameList())
                        .returns(descriptor.getTypeName())
                        .addStatement(format("return (%s) -> { }", parameterList(descriptor.getParameterList())))
                        .build());
    }

    private static Optional<MethodSpec> identity(
            final FunctionDescriptor descriptor,
            final String name,
            final String... nameArray)
    {
        return descriptor.getReturnOptional().flatMap(returnType -> descriptor.getParameterList().stream().findFirst().map(parameter ->
        {
            final FunctionDescriptor descriptorInner = new FunctionDescriptor(
                    descriptor.getClassName().packageName(),
                    descriptor.getParameterList().size(),
                    Optional.of(parameter),
                    descriptor.getExceptionOptional());

            return MethodSpec
                    .methodBuilder(name)
                    .addModifiers(PUBLIC, STATIC)
                    .addTypeVariables(Stream.concat(descriptorInner.getParameterList().stream(), descriptorInner.getExceptionOptional().map(Stream::of).orElseGet(Stream::empty)).collect(toList()))
                    .returns(descriptorInner.getTypeName())
                    .addStatement(format("return (%s) -> $N", parameterList(descriptorInner.getParameterList())), parameterSpec(parameter).name)
                    .build();
        }));
    }
}