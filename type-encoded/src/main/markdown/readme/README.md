[![Workflow Maven Deploy](https://github.com/drewctaylor/maven-require-type-encoded-constrain/workflows/workflow-maven-deploy/badge.svg)](https://github.com/drewctaylor/maven-require-type-encoded-constrain/workflows/workflow-maven-deploy/badge.svg)
[![Code Coverage](https://codecov.io/gh/drewctaylor/maven-require-type-encoded-constrain/branch/trunk/graph/badge.svg)](https://codecov.io/gh/drewctaylor/maven-require-type-encoded-constrain)

# Type Encoded

This library provides a way to encode the following values as types: Peano numbers, integers, and decimals. 

Example:

```java
final class TypeEncodedDecimalTest 
{
    @Test
    void testExample()
    {
        // construct a type for the decimal 1.1
        final TypeEncodedDecimal<_1<__1$>> oneOne = decimal(_1(__1()));

        // construct a type for the decimal -2.2
        final TypeEncodedDecimal<Negative<_2<__2$>>> negativeTwoTwo = decimal(negative(_2(__2())));

        // define a function that accepts decimal 1.1
        final Function<TypeEncodedDecimal<_1<__1$>>, BigDecimal> functionOneOne = parameter ->
        {
            return parameter.toBigDecimal();
        };

        // define a function that accepts decimal -2.2
        final Function<TypeEncodedDecimal<Negative<_2<__2$>>>, BigDecimal> functionNegativeTwoTwo = parameter ->
        {
            return parameter.toBigDecimal();
        };

        // Logger.getAnonymousLogger().info(format("%s", functionOneOne.apply(negativeTwoTwo))); // <-- compiler error
        Logger.getAnonymousLogger().info(format("%s", functionOneOne.apply(oneOne)));
        // logs "1.1"

        // Logger.getAnonymousLogger().info(format("%s", functionNegativeTwoTwo.apply(oneOne))); // <-- compiler error
        Logger.getAnonymousLogger().info(format("%s", functionNegativeTwoTwo.apply(negativeTwoTwo)));
        // logs "-2.2"
    }
}
```

## To Use

1) Update the `pom.xml` to include a reference to the sonatype staging and snapshot repositories.

   For example:

    ```xml
    <repositories>
        <repository>
            <releases>
                <enabled>true</enabled>
            </releases>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
            <id>ossrh</id>
            <url>https://oss.sonatype.org/service/local/staging/deploy/maven2</url>
        </repository>
        <repository>
            <releases>
                <enabled>false</enabled>
            </releases>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
            <id>ossrh-snapshot</id>
            <url>https://oss.sonatype.org/content/repositories/snapshots</url>
        </repository>
    </repositories>
    ```

2) Update the `pom.xml` to include the library. 

    For example:
    
    ```xml
    <dependencies>
        <dependency>
            <groupId>${project.groupId}</groupId>
            <artifactId>${project.artifactId}</artifactId>
            <version>${project.version}</version>
        </dependency>
    </dependencies>
    ```
