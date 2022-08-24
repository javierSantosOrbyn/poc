package com.example

import io.micronaut.runtime.Micronaut.*
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.slf4j.bridge.SLF4JBridgeHandler

@OpenAPIDefinition(
    info = Info(
        title = "poc",
        version = "0.0.1"
    )
)
object Api {
}

fun main(args: Array<String>) {

    // Bridge JUL to Slf4j
    SLF4JBridgeHandler.removeHandlersForRootLogger()
    SLF4JBridgeHandler.install()

    run(*args)
}
