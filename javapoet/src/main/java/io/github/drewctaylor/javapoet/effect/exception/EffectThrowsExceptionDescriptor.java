package io.github.drewctaylor.javapoet.effect.exception;

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
 * A descriptor for an effect that may throw an exception.
 */
public final class EffectThrowsExceptionDescriptor implements DescriptorAbstract
{
    private static final String PACKAGE_NAME = "io.github.drewctaylor.effect.exception";
    private static final Optional<TypeVariableName> typeVariableNameForException = Optional.of(TypeVariableName.get("E", Exception.class));
    private static final Optional<TypeVariableName> typeVariableNameForReturn = Optional.empty();

    private final int parameterCount;
    private final String simpleName;
    private final ClassName className;

    /**
     * Constuct a descriptor for an effect that may produce an exception.
     *
     * @param parameterCount the parameter count
     */
    public EffectThrowsExceptionDescriptor(
            final int parameterCount)
    {
        requireZeroOrPositive(parameterCount, "parameterCount");

        this.parameterCount = parameterCount;
        this.simpleName = format("E%sE", parameterCount);
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
            final TypeName typeNameForException)
    {
        requireNonNull(typeNameListForParameter);
        requireNonNull(typeNameForException);

        return ParameterizedTypeName.get(new EffectThrowsExceptionDescriptor(typeNameListForParameter.size()).getClassName(), concat(typeNameListForParameter.stream(), of(typeNameForException)).toArray(TypeName[]::new));
    }
}
