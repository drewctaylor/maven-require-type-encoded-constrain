package io.github.drewctaylor.javapoet.function.exception;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;

import static io.github.drewctaylor.require.RequireNumberInteger.requireInteger;
import static io.github.drewctaylor.require.RequireNumberInteger.requireZeroOrPositive;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;
import static javax.lang.model.element.Modifier.PUBLIC;

/**
 * Returns java files that implement functions that throw exceptions - F0E through FnE, where n is the parameter count.
 */
public final class FunctionThrowsExceptionFactory
{
    private FunctionThrowsExceptionFactory()
    {
    }

    /**
     * Returns java files that implement functions that may throw exceptions - F0 through Fn, where n is the parameter
     * count.
     *
     * @param  parameterCountString     the parameter count
     * 
     * @return                          java files that implement functions that may throw exceptions - F0 through Fn, where
     *                                  n is the parameter count
     * 
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
                .mapToObj(parameterCountInner -> file(new FunctionThrowsExceptionDescriptor(parameterCountInner)))
                .collect(toList());
    }

    private static JavaFile file(
            final FunctionThrowsExceptionDescriptor functionThrowsExceptionDescriptor)
    {
        return JavaFile.builder(
                functionThrowsExceptionDescriptor.getClassName().packageName(),
                TypeSpec
                        .interfaceBuilder(functionThrowsExceptionDescriptor.getClassName().simpleName())
                        .addAnnotation(FunctionalInterface.class)
                        .addModifiers(PUBLIC)
                        .build())
                .skipJavaLangImports(true)
                .build();
    }
}