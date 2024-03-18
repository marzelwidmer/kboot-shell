package ch.keepcalm.kboot.shell

import ch.keepcalm.kboot.shell.commands.CreateNewProject
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.shell.command.annotation.EnableCommand

@SpringBootApplication
@EnableCommand(CreateNewProject::class)
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
