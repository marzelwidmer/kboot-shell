package ch.keepcalm.kboot.shell

import ch.keepcalm.kboot.shell.commands.annotation.CreateProject
import ch.keepcalm.kboot.shell.commands.annotation.HelloAnnotation
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.shell.command.annotation.EnableCommand

@SpringBootApplication
@EnableCommand(HelloAnnotation::class, CreateProject::class)
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
