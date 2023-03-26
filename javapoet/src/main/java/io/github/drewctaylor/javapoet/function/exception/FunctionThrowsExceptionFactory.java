package io.github.drewctaylor.javapoet.function.exception;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeVariableName;
import io.github.drewctaylor.javapoet.FunctionDescriptor;
import io.github.drewctaylor.javapoet.FunctionDescriptorUtility;

import java.util.Optional;

import static io.github.drewctaylor.require.RequireNumberInteger.requireInteger;
import static io.github.drewctaylor.require.RequireNumberInteger.requireZeroOrPositive;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

/**
 * Returns java files that implement functions that may throw exceptions - F0E through FnE, where n is the parameter
 * count.
 */
public final class FunctionThrowsExceptionFactory
{
    private FunctionThrowsExceptionFactory()
    {
    }

    /**
     * Returns java files that implement functions that may throw exceptions - F0E through FnE, where n is the parameter
     * count.
     *
     * @param  parameterCountString     the parameter count
     *
     * @return                          java files that implement functions that may throw exceptions - F0E through FnE,
     *                                  where n is the parameter count
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
                        "io.github.drewctaylor.function.exception",
                        parameterCountInner,
                        range(1, parameterCountInner + 1)
                                .mapToObj(parameterIndex -> TypeVariableName.get(format("P%s", parameterIndex)))
                                .collect(toList()),
                        Optional.ofNullable(TypeVariableName.get(format("R1"))),
                        Optional.ofNullable(TypeVariableName.get("E", Exception.class))))
                .map(FunctionDescriptorUtility::javaFile)
                .collect(toList());
    }
}
