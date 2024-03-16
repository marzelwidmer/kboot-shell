package ch.keepcalm.kboot.shell.commands

import ch.keepcalm.kboot.shell.client.DadJokeClient
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

@ShellComponent
class DadJokeCommands(val dadJokeClient: DadJokeClient) {

    @ShellMethod(key = ["dad-joke"], value = "Prints a dad joke to the console.")
    fun getDadJoke(): String {
        return dadJokeClient.random().joke
    }
}
