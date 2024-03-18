package ch.keepcalm.kboot.shell.commands

import org.springframework.shell.command.annotation.Command
import org.springframework.shell.command.annotation.Option
import org.springframework.shell.context.InteractionMode

@Command
class CreateNewProject() {

    @Command(command = ["create"], description = "Create a new project.")
    fun createNewProject(
        @Option(
            longNames = ["create"],
            label = "myLabel",
            defaultValue = "foo",
            shortNames = ['c'],
            description = "Create a new project"
        ) projectName: String
    ): String {
        createDirectory(projectName)
        return "Project created."
    }
    @Command(command = ["example"])
    fun stringWithShortOption(
        @Option(longNames = ["arg"], shortNames = ['a'], required = true) arg: String?
    ): String {
        return String.format("Hi '%s'", arg)
    }
}