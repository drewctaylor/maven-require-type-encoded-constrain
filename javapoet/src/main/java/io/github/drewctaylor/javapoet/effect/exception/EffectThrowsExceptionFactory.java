package io.github.drewctaylor.javapoet.effect.exception;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;

import static io.github.drewctaylor.require.RequireNumberInteger.requireInteger;
import static io.github.drewctaylor.require.RequireNumberInteger.requireZeroOrPositive;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;
import static javax.lang.model.element.Modifier.PUBLIC;

/**
 * Returns java files that implement effects that may throw an exception - from E0 to En, where n is the parameter
 * count.
 */
public final class EffectThrowsExceptionFactory
{
    private EffectThrowsExceptionFactory()
    {
    }

    /**
     * Returns java files that implement effects that may throw an exception - from E0 to En, where n is the parameter
     * count.
     *
     * @param  parameterCountString     the parameter count
     * 
     * @return                          java files that implement effects that may throw an exception - from E0 to En, where
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
        int parameterCountInteger = requireInteger(parameterCountString, "parameterCountString");
        int parameterCount = requireZeroOrPositive(parameterCountInteger, "parameterCountInteger");

        return range(0, parameterCount + 1)
                .mapToObj(parameterCountInner -> file(new EffectThrowsExceptionDescriptor(parameterCountInner)))
                .collect(toList());
    }

    private static JavaFile file(
            final EffectThrowsExceptionDescriptor effectThrowsExceptionDescriptor)
    {
        return JavaFile.builder(
                effectThrowsExceptionDescriptor.getClassName().packageName(),
                TypeSpec
                        .interfaceBuilder(effectThrowsExceptionDescriptor.getClassName().simpleName())
                        .addAnnotation(FunctionalInterface.class)
                        .addModifiers(PUBLIC)
                        .build())
                .skipJavaLangImports(true)
                .build();
    }
}