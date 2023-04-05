package io.github.drewctaylor.javapoet;

import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeVariableName;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static javax.lang.model.element.Modifier.FINAL;

/**
 * Utility methods for JavaPoet.
 */
public final class JavaPoetUtility
{
    private JavaPoetUtility()
    {
    }

    public static String parameterList(
            final List<TypeVariableName> typeVariableNameList)
    {
        return parameterList(typeVariableNameList.stream());
    }

    /**
     * Given a type variable name stream, return a parameter list.
     *
     * @param  typeVariableNameStream the type variable name stream
     * 
     * @return                        the parameter list
     */
    public static String parameterList(
            final Stream<TypeVariableName> typeVariableNameStream)
    {
        return typeVariableNameStream.map(JavaPoetUtility::parameterName).collect(Collectors.joining(", "));
    }

    /**
     * Given a type variable name, return a parameter spec.
     *
     * @param  typeVariableName the type variable name
     * 
     * @return                  the parameter spec
     */
    public static ParameterSpec parameterSpec(
            final TypeVariableName typeVariableName)
    {
        return ParameterSpec.builder(typeVariableName, parameterName(typeVariableName), FINAL).build();
    }

    /**
     * Given a type variable name, return a parameter name.
     *
     * @param  typeVariableName the type variable name
     * 
     * @return                  the parameter name
     */
    private static String parameterName(
            final TypeVariableName typeVariableName)
    {
        return typeVariableName.name.toLowerCase(Locale.US);
    }

}
