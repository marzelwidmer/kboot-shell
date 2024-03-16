package ch.keepcalm.kboot.shell.commands

import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import org.springframework.shell.standard.ShellOption

@ShellComponent
class HelloCommands {
    @ShellMethod(key = ["hello"], value = "Prints 'Hello, World!' to the console.")
    fun hello(@ShellOption(defaultValue = "World") arg: String): String {
        return "Hello, $arg!"
    }

    @ShellMethod(key = ["goodbye"], value = "Prints 'Goodbye, World!' to the console.")
    fun goodbye(): String {
        return "Goodbye, World!"
    }

}