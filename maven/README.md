[![Workflow Maven Deploy](https://github.com/drewctaylor/maven-require-type-encoded-constrain/workflows/workflow-maven-deploy/badge.svg)](https://github.com/drewctaylor/maven-require-type-encoded-constrain/workflows/workflow-maven-deploy/badge.svg)
[![Code Coverage](https://codecov.io/gh/drewctaylor/maven-require-type-encoded-constrain/branch/trunk/graph/badge.svg)](https://codecov.io/gh/drewctaylor/maven-require-type-encoded-constrain)

# Maven

This is a parent POM. It ensures that child projects have a consistent configuration, including:

* Consistent Java release and source format (imports, spacing).
* Consistent Maven version and POM format (element ordering).
* Consistent Maven plugin and dependency version reporting.
* Consistent JaCoCo reporting.
* Consistent README.md location and variable filtering.

## To Use Maven

To use maven:

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

2) Update the `pom.xml` to include a reference to this parent POM.

    For example:

    ```xml
    <parent>
        <groupId>io.github.drewctaylor</groupId>
        <artifactId>maven</artifactId>
        <version>0.0.3-SNAPSHOT</version>
    </parent>
    ```