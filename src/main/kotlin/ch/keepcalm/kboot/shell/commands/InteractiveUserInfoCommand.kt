package ch.keepcalm.kboot.shell.commands

import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import org.springframework.shell.standard.ShellOption

@ShellComponent
class InteractiveUserInfoCommand {

    private var name: String? = null
    private var age: Int? = null

    @ShellMethod("Collect user information")
    fun collectInfo(@ShellOption(help = "Your name") name: String?, @ShellOption(help = "Your age") age: Int?): String {
        if (name.isNullOrBlank() || age == null) {
            return "Please provide both name and age."
        }
        this.name = name
        this.age = age
        return "Done. $name with age $age."
    }
}
