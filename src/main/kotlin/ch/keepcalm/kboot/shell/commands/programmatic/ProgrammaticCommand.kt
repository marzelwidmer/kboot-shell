package ch.keepcalm.kboot.shell.commands.programmatic

import org.springframework.context.annotation.Bean
import org.springframework.shell.command.CommandRegistration
import org.springframework.stereotype.Component

@Component
class ProgrammaticCommand {

    @Bean
    fun commandRegistry(): CommandRegistration {
     return CommandRegistration.builder()
        .command("programmatic")
         .description("Prints 'Hello, World!' to the console.")
         .withTarget()
         .function { "Hello from programmatic command" }
         .and()
         .build()

    }
}