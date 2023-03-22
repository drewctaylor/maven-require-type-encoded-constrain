package io.github.drewctaylor.javapoet.effect;

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

/**
 * A descriptor for an effect.
 */
public final class EffectDescriptor implements DescriptorAbstract
{
    private static final String PACKAGE_NAME = "io.github.drewctaylor.effect";
    private static final Optional<TypeVariableName> typeVariableNameForException = Optional.empty();
    private static final Optional<TypeVariableName> typeVariableNameForReturn = Optional.empty();

    private final int parameterCount;
    private final String simpleName;
    private final ClassName className;

    /**
     * Construct a descriptor for an effect.
     *
     * @param parameterCount the parameter count
     */
    public EffectDescriptor(
            final int parameterCount)
    {
        requireZeroOrPositive(parameterCount, "parameterCount");

        this.parameterCount = parameterCount;
        this.simpleName = format("E%s", parameterCount);
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
            final List<TypeName> typeNameListForParameter)
    {
        requireNonNull(typeNameListForParameter);

        return ParameterizedTypeName.get(new EffectDescriptor(typeNameListForParameter.size()).getClassName(), typeNameListForParameter.toArray(new TypeName[]
        {}));
    }
}
