package com.mint.ecommerce.webservice.sales

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class SalesRouter {

    companion object {
        const val ROUTER = "/api/v1/sales"
    }

    @Bean
    fun salesApi(handler: SalesHandler) = coRouter {
        accept(MediaType.APPLICATION_JSON).nest {
            ROUTER.nest {
                GET("/{saleId}", handler::get)
                POST("", handler::post)
            }
        }
    }
}