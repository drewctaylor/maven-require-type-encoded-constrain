# Maven Resources

These are resources for a maven parent POM, inlcuding:

* An Eclipse formatter configuration file for spotless-maven-plugin.
* A ruleset for versions-maven-plugin.

## To Use Maven Resources

To use maven resources:

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

   For example, in the configuration of spotless-maven-plugin:

    ```xml
   <plugin>
       <groupId>com.diffplug.spotless</groupId>
       <artifactId>spotless-maven-plugin</artifactId>
       <version>2.22.0</version>
       <configuration>
           <java>
               <importOrder>
                   <order>,java,javax,\#</order>
               </importOrder>
               <removeUnusedImports/>
               <eclipse>
                   <version>4.19.0</version>
                   <file>io/github/drewctaylor/maven-resource/eclipse-formatter-config.xml</file>
               </eclipse>
           </java>
       </configuration>
       <dependencies>
           <dependency>
               <groupId>io.github.drewctaylor</groupId>
               <artifactId>maven-resource</artifactId>
               <version>0.0.2</version>
           </dependency>
       </dependencies>
       <executions>
           <execution>
               <goals>
                   <goal>apply</goal>
               </goals>
               <phase>process-sources</phase>
           </execution>
       </executions>
   </plugin>
   ```

   In the configuration of versions-maven-plugin:

    ```xml
   <plugin>
       <groupId>org.codehaus.mojo</groupId>
       <artifactId>versions-maven-plugin</artifactId>
       <version>2.10.0</version>
       <configuration>
           <rulesUri>classpath:///io/github/drewctaylor/maven-resource/ruleset.xml</rulesUri>
       </configuration>
       <dependencies>
           <dependency>
               <groupId>io.github.drewctaylor</groupId>
               <artifactId>maven-resource</artifactId>
               <version>0.0.2</version>
           </dependency>
       </dependencies>
       <executions>
           <execution>
               <goals>
                   <goal>display-dependency-updates</goal>
                   <goal>display-plugin-updates</goal>
               </goals>
               <phase>validate</phase>
           </execution>
       </executions>
   </plugin>
   ```