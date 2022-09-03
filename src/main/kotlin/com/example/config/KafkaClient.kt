package com.example.config

import com.example.model.User
import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.Topic


@KafkaClient
interface KafkaClient {

    @Topic("Users")
    open fun sendUser(@KafkaKey id: Int?, user: User?)

}