[![Workflow Maven Package](https://github.com/drewctaylor/maven/workflows/workflow-maven-package/badge.svg)](https://github.com/drewctaylor/maven/workflows/workflow-maven-package/badge.svg)
[![Workflow Maven Deploy](https://github.com/drewctaylor/maven/workflows/workflow-maven-deploy/badge.svg)](https://github.com/drewctaylor/maven/workflows/workflow-maven-deploy/badge.svg)
[![Code Coverage](https://codecov.io/gh/drewctaylor/maven/branch/trunk/graph/badge.svg)](https://codecov.io/gh/drewctaylor/maven)

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
         <id>ossrh</id>
         <url>https://oss.sonatype.org/service/local/staging/deploy/maven2</url>
      </repository>
      <repository>
         <id>ossrh</id>
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
        <version>0.0.1-SNAPSHOT</version>
    </parent>
    ```