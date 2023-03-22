package io.github.drewctaylor.javapoet.function;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeVariableName;
import io.github.drewctaylor.javapoet.DescriptorAbstract;

import java.util.List;
import java.util.Optional;

import static io.github.drewctaylor.require.RequireNumberInteger.requireZeroOrPositive;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Stream.concat;
import static java.util.stream.Stream.of;

/**
 * A descriptor for a function.
 */
public final class FunctionDescriptor implements DescriptorAbstract
{
    private static final String PACKAGE_NAME = "io.github.drewctaylor.function";
    private static final Optional<TypeVariableName> typeVariableNameForException = Optional.empty();
    private static final Optional<TypeVariableName> typeVariableNameForReturn = Optional.of(TypeVariableName.get("R1"));

    private final int parameterCount;
    private final String simpleName;
    private final ClassName className;

    /**
     * Construct a descriptor for a function.
     *
     * @param parameterCount the parameter count
     */
    public FunctionDescriptor(
            final int parameterCount)
    {
        requireZeroOrPositive(parameterCount, "parameterCount");

        this.parameterCount = parameterCount;
        this.simpleName = format("F%s", parameterCount);
        this.className = ClassName.get(PACKAGE_NAME, simpleName);
    }

    public int getParameterCount()
    {
        return parameterCount;
    }

    public ClassName getClassName()
    {
        return className;
    }

    public Optional<TypeVariableName> getTypeVariableNameForException()
    {
        return typeVariableNameForException;
    }

    public Optional<TypeVariableName> getTypeVariableNameForReturn()
    {
        return typeVariableNameForReturn;
    }

    public static ParameterizedTypeName parameterizedTypeName(
            final List<TypeName> typeNameListForParameter,
            final TypeName typeNameReturn)
    {
        requireNonNull(typeNameListForParameter);
        requireNonNull(typeNameReturn);

        return ParameterizedTypeName.get(new FunctionDescriptor(typeNameListForParameter.size()).getClassName(), concat(typeNameListForParameter.stream(), of(typeNameReturn)).toArray(TypeName[]::new));
    }
}
