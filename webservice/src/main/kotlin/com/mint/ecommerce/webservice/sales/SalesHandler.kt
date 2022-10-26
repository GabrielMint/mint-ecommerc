package com.mint.ecommerce.webservice.sales

import com.mint.ecommerce.business.sales.services.SalesOrchestrator
import com.mint.ecommerce.webservice.sales.requests.SaleCreationRequest
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.awaitBodyOrNull
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.buildAndAwait
import java.util.UUID

@Component
class SalesHandler(
    private val salesOrchestrator: SalesOrchestrator
) {
    suspend fun get(request: ServerRequest): ServerResponse {
        val saleId = UUID.fromString(request.pathVariable("saleId"))
        val sale = salesOrchestrator.getSale(saleId) ?:
            return ServerResponse.notFound().buildAndAwait()
        return ServerResponse.ok().bodyValueAndAwait(sale)
    }


    suspend fun post(request: ServerRequest): ServerResponse {
        val sale = request.awaitBodyOrNull<SaleCreationRequest>() ?: return ServerResponse.badRequest().buildAndAwait()
        val newSale = sale.toNewSale()
        salesOrchestrator.createSale(newSale)
        return ServerResponse.ok().bodyValueAndAwait(newSale)
    }
}