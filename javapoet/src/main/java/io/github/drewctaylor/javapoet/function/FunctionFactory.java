package io.github.drewctaylor.javapoet.function;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeVariableName;

import java.util.stream.Stream;

import static io.github.drewctaylor.require.RequireNumberInteger.requireInteger;
import static io.github.drewctaylor.require.RequireNumberInteger.requireZeroOrPositive;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;
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
     * @param  parameterCountString     the parameter count
     * 
     * @return                          java source that implement functions - F0 through Fn, where n is the parameter count
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
                .mapToObj(parameterCountInner -> file(new FunctionDescriptor(parameterCountInner)))
                .collect(toList());
    }

    private static JavaFile file(
            final FunctionDescriptor functionDescriptor)
    {
        return JavaFile.builder(
                functionDescriptor.getClassName().packageName(),
                TypeSpec
                        .interfaceBuilder(functionDescriptor.getClassName().simpleName())
                        .addAnnotation(FunctionalInterface.class)
                        .addModifiers(PUBLIC)
                        .addTypeVariables(typeVariableNameList(0, functionDescriptor.getParameterCount()).collect(toList()))
                        .build())
                .skipJavaLangImports(true)
                .build();
    }

    /**
     * Return a type variable name list for the given parameter index and parameter count.
     *
     * @param  parameterFirst the given parameter index
     * @param  parameterCount the given parameter count
     * 
     * @return                the type variable name list
     */
    private static Stream<TypeVariableName> typeVariableNameList(
            final int parameterFirst,
            final int parameterCount)
    {
        return range(parameterFirst, parameterCount).mapToObj(FunctionFactory::typeVariableNameP);
    }

    /**
     * Return a type variable name for the given parameter index.
     * <p>
     * 0 -> P1
     *
     * @param  parameterIndex the given parameter index
     * 
     * @return                the type variable name
     */
    private static TypeVariableName typeVariableNameP(
            final int parameterIndex)
    {
        requireZeroOrPositive(parameterIndex, "parameterIndex");

        return TypeVariableName.get(format("P%s", parameterIndex + 1));
    }

}