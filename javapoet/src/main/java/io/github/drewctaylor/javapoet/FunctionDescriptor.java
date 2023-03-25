package io.github.drewctaylor.javapoet;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeVariableName;

import java.util.List;
import java.util.Optional;

import static io.github.drewctaylor.require.Require.requireNonNull;

public class FunctionDescriptor
{
    private final ClassName className;
    private final List<TypeVariableName> typeVariableNameForParameter;
    private final Optional<TypeVariableName> typeVariableNameForReturn;
    private final Optional<TypeVariableName> typeVariableNameForException;

    /**
     * Construct a descriptor for a function.
     *
     * @param parameterCount the parameter count
     */
    public FunctionDescriptor(
            final ClassName className,
            final List<TypeVariableName> typeVariableNameForParameter,
            final Optional<TypeVariableName> typeVariableNameForReturn,
            final Optional<TypeVariableName> typeVariableNameForException)
    {
        this.className = requireNonNull(className, "className");
        this.typeVariableNameForParameter = requireNonNull(typeVariableNameForParameter, "typeVariableNameForParameter");
        this.typeVariableNameForReturn = requireNonNull(typeVariableNameForReturn, "typeVariableNameForReturn");
        this.typeVariableNameForException = requireNonNull(typeVariableNameForException, "typeVariableNameForException");
    }

    public ClassName getClassName()
    {
        return this.className;
    }

    public List<TypeVariableName> getTypeVariableNameForParameter()
    {
        return this.typeVariableNameForParameter;
    }

    public Optional<TypeVariableName> getTypeVariableNameForReturn()
    {
        return this.typeVariableNameForReturn;
    }

    public Optional<TypeVariableName> getTypeVariableNameForException()
    {
        return this.typeVariableNameForException;
    }
}
