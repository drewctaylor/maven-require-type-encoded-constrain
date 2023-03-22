package io.github.drewctaylor.javapoet;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeVariableName;

import java.util.Optional;

public interface DescriptorAbstract
{
    int getParameterCount();

    ClassName getClassName();

    Optional<TypeVariableName> getTypeVariableNameForException();

    Optional<TypeVariableName> getTypeVariableNameForReturn();
}
