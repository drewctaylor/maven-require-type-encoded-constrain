package io.github.drewctaylor.javapoet;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.concat;
import static javax.lang.model.element.Modifier.PUBLIC;

public final class FunctionDescriptorUtility
{
    private FunctionDescriptorUtility()
    {
    }

    public static JavaFile javaFile(
            final FunctionDescriptor descriptor)
    {
        return JavaFile.builder(
                        descriptor.getClassName().packageName(),
                        TypeSpec
                                .interfaceBuilder(descriptor.getClassName().simpleName())
                                .addModifiers(PUBLIC)
                                .addTypeVariables(
                                        concat(
                                                concat(
                                                        descriptor.getTypeVariableNameForParameter().stream(),
                                                        descriptor.getTypeVariableNameForReturn().map(Stream::of).orElseGet(Stream::empty)),
                                                descriptor.getTypeVariableNameForException().map(Stream::of).orElseGet(Stream::empty)).collect(toList()))
                                .build())
                .skipJavaLangImports(true)
                .build();
    }
}
