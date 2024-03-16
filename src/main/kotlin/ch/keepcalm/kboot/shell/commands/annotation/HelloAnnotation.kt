package ch.keepcalm.kboot.shell.commands.annotation

import org.springframework.shell.command.annotation.Command

@Command
class HelloAnnotation() {

    @Command(command = ["hello"], description = "Prints 'Hello, World!' to the console.")
    fun hello(): String {
        return "Hello, World!"
    }

}
