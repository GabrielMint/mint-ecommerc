package com.mint.ecommerce.webservice

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication(scanBasePackages = ["com.mint.ecommerce.*"])
@EnableAutoConfiguration
class Application
fun main(args: Array<String>) {
    runApplication<Application>(*args)
}