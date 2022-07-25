package com.mint.ecommerce.webservice.sales

import com.mint.ecommerce.webservice.sales.requests.SaleCreationRequest
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.awaitBody
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Component
class SalesHandler {

    suspend fun get(request: ServerRequest): ServerResponse =
        ServerResponse.ok().bodyValueAndAwait("Hello World!")


    suspend fun post(request: ServerRequest) : ServerResponse {
        val sale = request.awaitBody<SaleCreationRequest>()
        return ServerResponse.ok().bodyValueAndAwait(sale)
    }
}