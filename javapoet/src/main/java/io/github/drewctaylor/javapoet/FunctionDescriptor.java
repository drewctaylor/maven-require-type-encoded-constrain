package io.github.drewctaylor.javapoet;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeVariableName;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.github.drewctaylor.require.Require.requireNonNull;
import static io.github.drewctaylor.require.RequireNumberInteger.requireZeroOrPositive;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;
import static java.util.stream.Stream.concat;
import static javax.lang.model.element.Modifier.FINAL;

public class FunctionDescriptor
{
    private final String packageName;
    private final int parameterCount;
    private final ClassName className;
    private final List<TypeVariableName> parameterList;
    private final Optional<TypeVariableName> returnOptional;
    private final Optional<TypeVariableName> exceptionOptional;
    private final List<TypeVariableName> typeVariableNameList;
    private final TypeName typeName;
    private final ParameterSpec parameterSpec;
    private final Optional<TypeName> typeNameOther;

    public FunctionDescriptor(
            final String packageName,
            final int parameterCount,
            final Optional<TypeVariableName> returnOptional,
            final Optional<TypeVariableName> exceptionOptional)
    {
        this.packageName = requireNonNull(packageName, "packageName");
        this.parameterCount = requireZeroOrPositive(parameterCount, "parameterCount");
        this.returnOptional = requireNonNull(returnOptional, "returnOptional");
        this.exceptionOptional = requireNonNull(exceptionOptional, "exceptionOptional");

        this.className = ClassName.get(packageName, returnOptional.map(ignore -> "F").orElse("E") + parameterCount + exceptionOptional.map(ignore -> "E").orElse(""));
        this.parameterList = range(1, parameterCount + 1)
                .mapToObj(parameterIndex -> TypeVariableName.get(format("P%s", parameterIndex)))
                .collect(toList());
        this.typeVariableNameList = concat(
                parameterList.stream(),
                concat(
                        returnOptional.map(Stream::of).orElseGet(Stream::empty),
                        exceptionOptional.map(Stream::of).orElseGet(Stream::empty))).collect(Collectors.toList());
        this.typeName = typeVariableNameList.isEmpty() ?
                className :
                ParameterizedTypeName.get(className, typeVariableNameList.toArray(new TypeVariableName[0]));
        this.parameterSpec = ParameterSpec.builder(typeName, className.simpleName().toLowerCase(), FINAL).build();

        this.typeNameOther = typeVariableNameList.size() == 0 ?
                Optional.empty() :
                Optional.ofNullable(typeVariableNameList.size() == 1 ?
                        ClassName.get(packageName, returnOptional.map(ignore -> "F").orElse("E") + (parameterCount - 1) + exceptionOptional.map(ignore -> "E").orElse("")) :
                        ParameterizedTypeName.get(ClassName.get(packageName, returnOptional.map(ignore -> "F").orElse("E") + (parameterCount - 1) + exceptionOptional.map(ignore -> "E").orElse("")), typeVariableNameList.stream().skip(1).collect(Collectors.toList()).toArray(new TypeVariableName[0])));
    }

    public ClassName getClassName()
    {
        return this.className;
    }

    public List<TypeVariableName> getParameterList()
    {
        return this.parameterList;
    }

    public Optional<TypeVariableName> getReturnOptional()
    {
        return this.returnOptional;
    }

    public Optional<TypeVariableName> getExceptionOptional()
    {
        return this.exceptionOptional;
    }

    public List<TypeVariableName> getTypeVariableNameList()
    {
        return this.typeVariableNameList;
    }

    public TypeName getTypeName()
    {
        return this.typeName;
    }

    public ParameterSpec getParameterSpec()
    {
        return this.parameterSpec;
    }

    public Optional<TypeName> getTypeNameForArgument()
    {
        return this.typeNameOther;
    }
}
