[![Workflow Maven Package](https://github.com/drewctaylor/type-encoded/workflows/workflow-maven-package/badge.svg)](https://github.com/drewctaylor/type-encoded/workflows/workflow-maven-package/badge.svg)
[![Workflow Maven Deploy](https://github.com/drewctaylor/type-encoded/workflows/workflow-maven-deploy/badge.svg)](https://github.com/drewctaylor/type-encoded/workflows/workflow-maven-deploy/badge.svg)
[![Code Coverage](https://codecov.io/gh/drewctaylor/type-encoded/branch/trunk/graph/badge.svg)](https://codecov.io/gh/drewctaylor/type-encoded)

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

1) Update the `~/.m2/settings.xml` to include a github username or github email address and a [github personal access token](https://help.github.com/en/github/authenticating-to-github/creating-a-personal-access-token-for-the-command-line).

    For example:

    ```xml
    <settings>
        <servers>
            <server>
                <id>type-encoded</id>
                <username>github-username-or-email-address</username>
                <password>github-personal-access-token</password>
            </server>
        </servers>
    </settings>
    ```

2) Update the `pom.xml` to include a reference to the repository.

    For example:

    ```xml
    <repositories>
        <repository>
            <id>type-encoded</id>
            <name>GitHub Packages</name>
            <url>https://maven.pkg.github.com/drewctaylor/type-encoded</url>
        </repository>
    </repositories>
    ```

3) Update the `pom.xml` to include the library. 

    For example:
    
    ```xml
    <dependencies>
        <dependency>
            <groupId>io.github.drewctaylor</groupId>
            <artifactId>type-encoded</artifactId>
            <version>1.0.0-SNAPSHOT</version>
        </dependency>
    </dependencies>
    ```
