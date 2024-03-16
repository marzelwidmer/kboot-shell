package ch.keepcalm.kboot.shell.client

import ch.keepcalm.kboot.shell.model.DadJokeResponse
import org.springframework.web.service.annotation.GetExchange

interface DadJokeClient {

    // http GET https://icanhazdadjoke.com/ "Accept: application/json"
    @GetExchange  (value = "/")
    fun random(): DadJokeResponse
}