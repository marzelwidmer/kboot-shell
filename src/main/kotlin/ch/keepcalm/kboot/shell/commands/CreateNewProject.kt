package ch.keepcalm.kboot.shell.commands

import org.springframework.shell.command.annotation.Command
import org.springframework.shell.command.annotation.Option
import org.springframework.shell.context.InteractionMode

@Command
class CreateNewProject() {

    @Command(command = ["create"], description = "Create a new project.")
    fun createNewProject(
        @Option(
            longNames = ["projectName"],
            required = true,
            label = "project name",
            shortNames = ['n'],
            description = "project name eg. foo used for package name"
        ) projectName: String,
        @Option(
            longNames = ["serviceName"],
            required = true,
            label = "service name",
            shortNames = ['s'],
            description = "service name eg. foo-service"
        ) serviceName: String,
        @Option(
            longNames = ["flavor"],
            required = true,
            label = "flavor",
            shortNames = ['f'],
            description = "project flavor eg. webflux,webmvc,camel"
        ) projectFlavor: String
    ): String {
        createDirectory(projectName = projectName, projectFlavor = projectFlavor, serviceName = serviceName)
        return "Project created."
    }




    @Command(command = ["example"])
    fun stringWithShortOption(
        @Option(longNames = ["arg"], shortNames = ['a'], required = true) arg: String?
    ): String {
        return String.format("Hi '%s'", arg)
    }


    // load file from resources folder
    fun loadFile(fileName: String): String {
        val resource = javaClass.classLoader.getResource(fileName)
        return resource.readText()
    }
}