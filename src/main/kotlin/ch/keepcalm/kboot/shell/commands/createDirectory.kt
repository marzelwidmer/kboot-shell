package ch.keepcalm.kboot.shell.commands

import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths

fun createDirectory(projectName: String, projectFlavor: String, serviceName: String): Boolean {
    try {
        val userHome = System.getProperty("user.home")
        val directoryPath = "$userHome/tmp/$serviceName"

        val directoryMainPath = "$directoryPath/src/main/kotlin"
        val directoryMainPackagePath = "$directoryPath/src/main/kotlin/ch/myhelsana/$projectName"
        val directoryMainResourcesPath = "$directoryPath/src/main/resources"


        Files.createDirectories(Paths.get(directoryMainPath))
        Files.createDirectories(Paths.get(directoryMainPackagePath))
        Files.createDirectories(Paths.get(directoryMainResourcesPath))


        // Test
        val directoryTestPath = "$directoryPath/src/test/kotlin"
        val directoryTestPackagePath = "$directoryPath/src/test/kotlin/ch/myhelsana/$projectName"
        val directoryTestResourcesPath = "$directoryPath/src/test/resources"

        Files.createDirectories(Paths.get(directoryTestPath))
        Files.createDirectories(Paths.get(directoryTestPackagePath))
        Files.createDirectories(Paths.get(directoryTestResourcesPath))

        val parentPomVersion = "0.0.0"
        val parentPomFlavor = projectFlavor

        val pomXmlContent = """
            <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
                <modelVersion>4.0.0</modelVersion>
                
                <parent>
                    <groupId>ch.myhelsana</groupId>
                    <artifactId>starter-parent-$parentPomFlavor</artifactId>
                    <version>$parentPomVersion</version>
                </parent>
                
                <artifactId>$serviceName</artifactId>
                <version>${'$'}{revision}</version> 
                <name>$projectName</name>
                <description>MyHelsana  - $serviceName</description>
                
            </project>
        """.trimIndent()


        val pomFile = File("$directoryPath/pom.xml")
        pomFile.writeText(pomXmlContent)


        // create kotlin main class in main package
        val mainClassContent = """
            package ch.myhelsana.$projectName

            import org.springframework.boot.autoconfigure.SpringBootApplication
            import org.springframework.boot.runApplication

            @SpringBootApplication
            class Application
            fun main(args: Array<String>) {
                runApplication<Application>(*args)
            }
        """.trimIndent()

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
