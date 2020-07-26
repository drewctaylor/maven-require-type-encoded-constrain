[![Workflow Maven Package](https://github.com/drewctaylor/${project.artifactId}/workflows/workflow-maven-package/badge.svg)](https://github.com/drewctaylor/${project.artifactId}/workflows/workflow-maven-package/badge.svg)
[![Workflow Maven Deploy](https://github.com/drewctaylor/${project.artifactId}/workflows/workflow-maven-deploy/badge.svg)](https://github.com/drewctaylor/${project.artifactId}/workflows/workflow-maven-deploy/badge.svg)
[![Code Coverage](https://codecov.io/gh/drewctaylor/${project.artifactId}/branch/trunk/graph/badge.svg)](https://codecov.io/gh/drewctaylor/${project.artifactId})

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

## To Use Type Encoded

To use Type Encoded:

1) Update your `~/.m2/settings.xml` to include your github username or github email address and your [github personal access token](https://help.github.com/en/github/authenticating-to-github/creating-a-personal-access-token-for-the-command-line).

    For example:

    ```xml
    <settings>
        <servers>
            <server>
                <id>${project.artifactId}</id>
                <username>your-github-username-or-email-address</username>
                <password>your-github-personal-access-token</password>
            </server>
        </servers>
    </settings>
    ```

2) Update your `pom.xml` to include a reference to the plugin repository.

    For example:

    ```xml
    <repositories>
        <repository>
            <id>${project.artifactId}</id>
            <name>GitHub Packages</name>
            <url>https://maven.pkg.github.com/drewctaylor/${project.artifactId}</url>
        </repository>
    </repositories>
    ```

3) Update your `pom.xml` to include the plugin. 

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
