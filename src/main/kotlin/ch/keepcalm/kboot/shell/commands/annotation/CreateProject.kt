package ch.keepcalm.kboot.shell.commands.annotation

import org.springframework.shell.command.annotation.Command
import org.springframework.shell.command.annotation.Option
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths

@Command
class CreateProject() {

    @Command(command = ["create"], description = "Create a new project.")
    fun createProject(@Option(longNames = ["create"] , description = "Create a new project") create: String): String {
        createDirectory(create)
        return "Done"
    }

}

fun createDirectory(directoryPath: String): Boolean {
    try {
        Files.createDirectories(Paths.get(directoryPath))
        println("Directory created successfully at: $directoryPath")
        return true
    } catch (e: IOException) {
        println("Failed to create the directory: ${e.message}")
        return false
    }
}