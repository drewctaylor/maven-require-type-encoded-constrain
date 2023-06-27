package io.github.drewctaylor.javapoet.effect.exception;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeVariableName;
import io.github.drewctaylor.javapoet.FunctionDescriptor;
import io.github.drewctaylor.javapoet.FunctionDescriptorUtility;

import static io.github.drewctaylor.require.RequireNumberInteger.requireInteger;
import static io.github.drewctaylor.require.RequireNumberInteger.requireZeroOrPositive;
import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

/**
 * Returns java files that implement effects that may throw exceptions - E0E through EnE, where n is the parameter
 * count.
 */
public final class EffectThrowsExceptionFactory
{
    private EffectThrowsExceptionFactory()
    {
    }

    /**
     * Returns java files that implement effects that may throw exceptions - E0E through EnE, where n is the parameter
     * count.
     *
     * @param  parameterCountString     the parameter count
     *
     * @return                          java files that implement effects that may throw exceptions - E0E through EnE, where
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
                .mapToObj(parameterCountInner -> new FunctionDescriptor(
                        "io.github.drewctaylor.effect.exception",
                        parameterCountInner,
                        empty(),
                        ofNullable(TypeVariableName.get("E", Exception.class))))
                .map(FunctionDescriptorUtility::javaFile)
                .collect(toList());
    }
}
