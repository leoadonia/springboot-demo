## 发布

### 使用assembly打包

在 `pom.xml` 中增加插件:

```
<plugin>
    <artifactId>maven-assembly-plugin</artifactId>
    <version>3.1.0</version>
    <configuration>
        <!-- 不使用 assembly.xml 中id作为发布包名称的一部分，只使用 finalName 定义，默认是 artifactId-version.tar.gz -->
        <appendAssemblyId>false</appendAssemblyId>
        <descriptors>
            <descriptor>src/main/assembly/assembly.xml</descriptor>
        </descriptors>
    </configuration>
    <executions>
        <execution>
            <id>make-assembly</id>
            <phase>package</phase>
            <goals>
                <goal>single</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

在执行 `mvn package` 时，会根据工程中 `src/main/assembly/assembly.xml` 的描述定义，组装发布包。

`assembly.xml`定义:

```
<?xml version="1.0" encoding="UTF-8"?>
<assembly>
    <!-- 可自定义，这里指定的是项目环境 -->
    <!-- fp-backend-0.0.1-SNAPSHOT.tar.gz  -->
    <!-- id必需 -->
    <id>fp-backend-${project.version}</id>

    <!-- 打包的类型，如果有N个，将会打N个类型的包 -->
    <formats>
        <format>tar.gz</format>
        <!--<format>zip</format>-->
    </formats>

    <!-- tar.gz包中是否包含一层父目录 -->
    <includeBaseDirectory>false</includeBaseDirectory>

    <fileSets>
        <!--
            0755->即用户具有读/写/执行权限，组用户和其它用户具有读写权限；
            0644->即用户具有读写权限，组用户和其它用户具有只读权限；
        -->
        <!-- 将src/bin目录下的所有文件输出到打包后的bin目录中 -->
        <fileSet>
            <directory>${basedir}/bin</directory>
            <outputDirectory>bin</outputDirectory>
            <fileMode>0755</fileMode>
            <includes>
                <include>**.sh</include>
            </includes>
        </fileSet>

        <!-- 指定输出target/classes中的配置文件到config目录中 -->
        <fileSet>
            <directory>${basedir}/target/classes</directory>
            <outputDirectory>config</outputDirectory>
            <fileMode>0644</fileMode>
            <includes>
                <include>application.yml</include>
                <include>application-*.yml</include>
                <include>static/**</include>
                <include>templates/**</include>
                <include>*.xml</include>
                <include>*.properties</include>
            </includes>
        </fileSet>

        <!-- 将第三方依赖打包到lib目录中 -->
        <fileSet>
            <directory>${basedir}/target/lib</directory>
            <outputDirectory>lib</outputDirectory>
            <fileMode>0755</fileMode>
        </fileSet>

        <!-- 将项目启动jar打包到boot目录中 -->
        <fileSet>
            <directory>${basedir}/target</directory>
            <outputDirectory>boot</outputDirectory>
            <fileMode>0755</fileMode>
            <includes>
                <include>${project.build.finalName}.jar</include>
            </includes>
        </fileSet>

        <!-- 包含根目录下的文件 -->
        <fileSet>
            <directory>${basedir}</directory>
            <includes>
                <include>NOTICE</include>
                <include>LICENSE</include>
                <include>*.md</include>
            </includes>
        </fileSet>
    </fileSets>

</assembly>
```
