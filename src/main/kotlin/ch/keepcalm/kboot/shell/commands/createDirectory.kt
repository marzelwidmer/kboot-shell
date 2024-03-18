package ch.keepcalm.kboot.shell.commands

import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths

fun createDirectory(projectName: String): Boolean {
    try {
        val userHome = System.getProperty("user.home")
        val directoryPath = "$userHome/tmp/$projectName-service"

        val directoryMainPath = "$directoryPath/src/main/kotlin"
        val directoryMainPackagePath = "$directoryPath/src/main/kotlin/ch/keepcalm/$projectName"
        val directoryMainResourcesPath = "$directoryPath/src/main/resources"


        Files.createDirectories(Paths.get(directoryMainPath))
        Files.createDirectories(Paths.get(directoryMainPackagePath))
        Files.createDirectories(Paths.get(directoryMainResourcesPath))


        // Test
        val directoryTestPath = "$directoryPath/src/test/kotlin"
        val directoryTestPackagePath = "$directoryPath/src/test/kotlin/ch/keepcalm/$projectName"
        val directoryTestResourcesPath = "$directoryPath/src/test/resources"

        Files.createDirectories(Paths.get(directoryTestPath))
        Files.createDirectories(Paths.get(directoryTestPackagePath))
        Files.createDirectories(Paths.get(directoryTestResourcesPath))

        val springBootVersion = "3.2.3"
        val pomXmlContent = """
            <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
                <modelVersion>4.0.0</modelVersion>
                <groupId>ch.keepcalm</groupId>
                <artifactId>$projectName</artifactId>
                <version>0.0.1-SNAPSHOT</version>
                <parent>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-parent</artifactId>
                    <version>$springBootVersion</version>
                    <relativePath/> <!-- lookup parent from repository -->
                </parent>
                <properties>
                    <java.version>17</java.version>
                    <kotlin.version>1.9.22</kotlin.version>
                </properties>
               <dependencies>
                    <dependency>
                        <groupId>org.springframework.boot</groupId>
                        <artifactId>spring-boot-starter-web</artifactId>
                    </dependency>
                    <dependency>
                        <groupId>com.fasterxml.jackson.module</groupId>
                        <artifactId>jackson-module-kotlin</artifactId>
                    </dependency>
                    <dependency>
                        <groupId>io.projectreactor.kotlin</groupId>
                        <artifactId>reactor-kotlin-extensions</artifactId>
                    </dependency>
                    <dependency>
                        <groupId>org.jetbrains.kotlin</groupId>
                        <artifactId>kotlin-reflect</artifactId>
                    </dependency>
                    <dependency>
                        <groupId>org.jetbrains.kotlin</groupId>
                        <artifactId>kotlin-stdlib</artifactId>
                    </dependency>
                    <dependency>
                        <groupId>org.jetbrains.kotlinx</groupId>
                        <artifactId>kotlinx-coroutines-reactor</artifactId>
                    </dependency>
                    <dependency>
                        <groupId>org.springframework.boot</groupId>
                        <artifactId>spring-boot-starter-test</artifactId>
                        <scope>test</scope>
                    </dependency>
                    <dependency>
                        <groupId>io.projectreactor</groupId>
                        <artifactId>reactor-test</artifactId>
                        <scope>test</scope>
                    </dependency>
                </dependencies>
                <build>
                    <sourceDirectory>${'$'}{project.basedir}/src/main/kotlin</sourceDirectory>
                    <testSourceDirectory>${'$'}{project.basedir}/src/test/kotlin</testSourceDirectory>
                    <plugins>
                        <plugin>
                            <groupId>org.graalvm.buildtools</groupId>
                            <artifactId>native-maven-plugin</artifactId>
                        </plugin>
                        <plugin>
                            <groupId>org.springframework.boot</groupId>
                            <artifactId>spring-boot-maven-plugin</artifactId>
                        </plugin>
                        <plugin>
                            <groupId>org.jetbrains.kotlin</groupId>
                            <artifactId>kotlin-maven-plugin</artifactId>
                            <configuration>
                                <args>
                                    <arg>-Xjsr305=strict</arg>
                                </args>
                                <compilerPlugins>
                                    <plugin>spring</plugin>
                                </compilerPlugins>
                            </configuration>
                            <dependencies>
                                <dependency>
                                    <groupId>org.jetbrains.kotlin</groupId>
                                    <artifactId>kotlin-maven-allopen</artifactId>
                                    <version>${'$'}{kotlin.version}</version>
                                </dependency>
                            </dependencies>
                        </plugin>
                    </plugins>
                </build>
            </project>
        """.trimIndent()


        val pomFile = File("$directoryPath/pom.xml")
        pomFile.writeText(pomXmlContent)


        // create kotlin main class in main package
        val mainClassContent = """
            package ch.keepcalm.$projectName

            import org.springframework.boot.autoconfigure.SpringBootApplication
            import org.springframework.boot.runApplication

            @SpringBootApplication
            class Application
            fun main(args: Array<String>) {
                runApplication<Application>(*args)
            }
        """
        val mainClassFile = File("$directoryMainPackagePath/Application.kt")
        mainClassFile.writeText(mainClassContent)


        // Done
        Files.createDirectories(Paths.get(directoryPath))

        println("Directory created successfully at: $directoryPath")
        return true
    } catch (e: IOException) {
        println("Failed to create the directory: ${e.message}")
        return false
    }


}
