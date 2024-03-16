package ch.keepcalm.kboot.shell

import ch.keepcalm.kboot.shell.client.DadJokeClient
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory

@SpringBootApplication
class Application {
    @Bean
    fun dadJokeClient(): DadJokeClient {
        val client =
            WebClient.builder()
                .baseUrl("https://icanhazdadjoke.com")
                .defaultHeader("Accept", "application/json")
                .build()
        return HttpServiceProxyFactory.builderFor(WebClientAdapter.create(client))
            .build()
            .createClient(DadJokeClient::class.java)
    }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
