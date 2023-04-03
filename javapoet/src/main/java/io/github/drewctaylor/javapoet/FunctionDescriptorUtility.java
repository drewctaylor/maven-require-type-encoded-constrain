package io.github.drewctaylor.javapoet;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeVariableName;
import io.github.drewctaylor.require.Require;

import java.util.Locale;
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
                .addMethod(constant(descriptor));

        superInterface(descriptor).ifPresent(builder::addSuperinterface);
        methodSpec(descriptor).ifPresent(builder::addMethod);
        partial(descriptor).ifPresent(builder::addMethod);
        exception(descriptor).ifPresent(builder::addMethod);
        identity(descriptor).ifPresent(builder::addMethod);
        reverse(descriptor).ifPresent(builder::addMethod);

        return JavaFile
                .builder(descriptor.getClassName().packageName(), builder.build())
                .skipJavaLangImports(true)
                .addStaticImport(Require.class, "requireNonNull")
                .build();
    }

    private static Optional<TypeName> superInterface(
            final FunctionDescriptor descriptor)
    {
        return descriptor.getExceptionOptional()
                .map(exceptionType -> Optional.<TypeName>empty())
                .orElse(descriptor.getReturnOptional()
                        .map(returnType -> descriptor.getParameterList().size() == 0 ?
                                Optional.<TypeName>ofNullable(ParameterizedTypeName.get(ClassName.get("java.util.function", "Supplier"), returnType)) :
                                descriptor.getParameterList().size() == 1 ?
                                        Optional.<TypeName>ofNullable(ParameterizedTypeName.get(ClassName.get("java.util.function", "Function"), descriptor.getParameterList().get(0), returnType)) :
                                        descriptor.getParameterList().size() == 2 ?
                                                Optional.<TypeName>ofNullable(ParameterizedTypeName.get(ClassName.get("java.util.function", "BiFunction"), descriptor.getParameterList().get(0), descriptor.getParameterList().get(1), returnType)) :
                                                Optional.<TypeName>empty())
                        .orElse(descriptor.getParameterList().size() == 1 ?
                                Optional.<TypeName>ofNullable(ParameterizedTypeName.get(ClassName.get("java.util.function", "Consumer"), descriptor.getParameterList().get(0))) :
                                descriptor.getParameterList().size() == 2 ?
                                        Optional.<TypeName>ofNullable(ParameterizedTypeName.get(ClassName.get("java.util.function", "BiConsumer"), descriptor.getParameterList().get(0), descriptor.getParameterList().get(1))) :
                                        Optional.<TypeName>empty()));
    }

    private static Optional<MethodSpec> methodSpec(
            final FunctionDescriptor descriptor)
    {
        return descriptor.getExceptionOptional()
                .map(exceptionType -> Optional.<MethodSpec>empty())
                .orElse(descriptor.getReturnOptional()
                        .map(returnType -> descriptor.getParameterList().size() == 0 ?
                                Optional.<MethodSpec>ofNullable(MethodSpec
                                        .methodBuilder("get")
                                        .addAnnotation(Override.class)
                                        .addModifiers(PUBLIC, DEFAULT)
                                        .returns(returnType)
                                        .addParameters(descriptor
                                                .getParameterList()
                                                .stream()
                                                .map(FunctionDescriptorUtility::parameterSpec)
                                                .collect(toList()))
                                        .addStatement(format("return f(%s)", parameterList(descriptor.getParameterList().stream())))
                                        .build()) :
                                descriptor.getParameterList().size() == 1 ?
                                        Optional.<MethodSpec>ofNullable(MethodSpec
                                                .methodBuilder("apply")
                                                .addAnnotation(Override.class)
                                                .addModifiers(PUBLIC, DEFAULT)
                                                .returns(returnType)
                                                .addParameters(descriptor
                                                        .getParameterList()
                                                        .stream()
                                                        .map(FunctionDescriptorUtility::parameterSpec)
                                                        .collect(toList()))
                                                .addStatement(format("return f(%s)", parameterList(descriptor.getParameterList().stream())))
                                                .build()) :
                                        descriptor.getParameterList().size() == 2 ?
                                                Optional.<MethodSpec>ofNullable(MethodSpec
                                                        .methodBuilder("apply")
                                                        .addAnnotation(Override.class)
                                                        .addModifiers(PUBLIC, DEFAULT)
                                                        .returns(returnType)
                                                        .addParameters(descriptor
                                                                .getParameterList()
                                                                .stream()
                                                                .map(FunctionDescriptorUtility::parameterSpec)
                                                                .collect(toList()))
                                                        .addStatement(format("return f(%s)", parameterList(descriptor.getParameterList().stream())))
                                                        .build()) :
                                                Optional.<MethodSpec>empty())
                        .orElse(descriptor.getParameterList().size() == 1 ?
                                Optional.<MethodSpec>ofNullable(MethodSpec
                                        .methodBuilder("accept")
                                        .addAnnotation(Override.class)
                                        .addModifiers(PUBLIC, DEFAULT)
                                        .addParameters(descriptor
                                                .getParameterList()
                                                .stream()
                                                .map(FunctionDescriptorUtility::parameterSpec)
                                                .collect(toList()))
                                        .addStatement(format("f(%s)", parameterList(descriptor.getParameterList().stream())))
                                        .build()) :
                                descriptor.getParameterList().size() == 2 ?
                                        Optional.<MethodSpec>ofNullable(MethodSpec
                                                .methodBuilder("accept")
                                                .addAnnotation(Override.class)
                                                .addModifiers(PUBLIC, DEFAULT)
                                                .addParameters(descriptor
                                                        .getParameterList()
                                                        .stream()
                                                        .map(FunctionDescriptorUtility::parameterSpec)
                                                        .collect(toList()))
                                                .addStatement(format("f(%s)", parameterList(descriptor.getParameterList().stream())))
                                                .build()) :
                                        Optional.<MethodSpec>empty()));
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

    private static Optional<MethodSpec> partial(
            final FunctionDescriptor descriptor)
    {
        final String parameterList1 = parameterList(descriptor.getParameterList().stream().skip(1));
        final String parameterList2 = parameterList(descriptor.getParameterList().stream());

        return descriptor.getParameterList().stream().findFirst().map(parameter -> MethodSpec
                .methodBuilder("partial")
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

    private static Optional<MethodSpec> reverse(
            final FunctionDescriptor descriptor)
    {
        return descriptor.getParameterList().size() == 0 ?
                Optional.empty() :
                Optional.ofNullable(MethodSpec
                        .methodBuilder("reverse")
                        .addModifiers(PUBLIC, DEFAULT)
                        .returns(descriptor.getTypeName())
                        .addStatement(format("return (%s) -> f(%s)", parameterList(descriptor.getParameterList().stream()), parameterList(descriptor.getParameterList().stream())))
                        .build());
    }

    // @formatter:off
//    /**
//     * Return the "curry" method spec given a parameter count, an exception, and an effect.
//     *
//     * @param parameterCount the given parameter count
//     * @param exception      the given exception
//     * @param effect         the given effect
//     * @return the "curry" method spec
//     */
//    private static MethodSpec curry(
//            final int parameterCount,
//            final boolean exception,
//            final boolean effect)
//    {
//        final var javadocReturn = format("a curried form of this %s", effect ? "effect" : "function");
//
//        final var javadoc = of(
//                format("Returns %s.", javadocReturn),
//                format("@return %s", javadocReturn))
//                .collect(joining(lineSeparator()));
//
//        return MethodSpec
//                .methodBuilder("curry")
//                .addJavadoc(javadoc)
//                .addModifiers(PUBLIC, DEFAULT)
//                .returns(parameterizedTypeNameCurry(parameterCount, exception, effect))
//                .addStatement(format("return %s -> f(%s)", parameterNameListDelimitedByArrow(parameterCount),
//                        parameterNameListDelimitedByComma(parameterCount)))
//                .build();
//    }
//
//    /**
//     * Return the "uncurry" method spec given a parameter count, an exception, and an effect.
//     *
//     * @param parameterCount the given parameter count
//     * @param exception      the given exception
//     * @param effect         the given effect
//     * @return the "uncurry" method spec
//     */
//    private static MethodSpec uncurry(
//            final int parameterCount,
//            final boolean exception,
//            final boolean effect)
//    {
//        final var r1 = typeVariableNameR(1);
//        final var parameterSpec = parameterSpec(parameterizedTypeNameCurry(parameterCount, exception, effect));
//
//        final var javadocReturn = format("an uncurried form of the given %s", effect ? "effect" : "function");
//
//        final var javadoc = concat(concat(concat(of(
//                                        format("Returns %s.", javadocReturn),
//                                        format("@param %s the given %s", parameterSpec.name, effect ? "effect" : "function")),
//                                typeVariableNameJavadocList(0, parameterCount, r1, exception, effect)),
//                        of(format("@return %s", javadocReturn))),
//                of(format("@throws NullPointerException if %s is null", parameterSpec.name)))
//                .collect(joining(lineSeparator()));
//
//        return MethodSpec
//                .methodBuilder("uncurry")
//                .addJavadoc(javadoc)
//                .addModifiers(PUBLIC, STATIC)
//                .addTypeVariables(typeVariableNameList(0, parameterCount, r1, exception, effect).collect(toList()))
//                .returns(parameterizedTypeName(parameterCount, r1, exception, effect))
//                .addParameter(parameterSpec)
//                .addStatement("$T.requireNonNull($N, \"$N\")", Require.class, parameterSpec.name, parameterSpec.name)
//                .addStatement(format("return (%s) -> $N.%s", parameterNameListDelimitedByComma(parameterCount),
//                        parameterNameListDelimitedByF(parameterCount)), parameterSpec.name)
//                .build();
//    }
    // @formatter:on

    private static ParameterSpec parameterSpec(
            final TypeVariableName typeVariableName)
    {
        return ParameterSpec.builder(typeVariableName, typeVariableName.name.toLowerCase(Locale.US), FINAL).build();
    }

    private static String parameterList(
            final Stream<TypeVariableName> typeVariableNameStream)
    {
        return typeVariableNameStream.map(typeVariableName -> typeVariableName.name.toLowerCase()).collect(Collectors.joining(", "));
    }
}