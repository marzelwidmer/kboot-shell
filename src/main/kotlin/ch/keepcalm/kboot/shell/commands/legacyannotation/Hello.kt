package ch.keepcalm.kboot.shell.commands.legacyannotation

import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import org.springframework.shell.standard.ShellOption

@ShellComponent
class LegacyHelloCommand {
    @ShellMethod(key = ["legacyHello"], value = "Prints 'Hello, World!' to the console.")
    fun hello(@ShellOption(defaultValue = "World") arg: String): String {
        return "Hello, $arg!"
    }
}