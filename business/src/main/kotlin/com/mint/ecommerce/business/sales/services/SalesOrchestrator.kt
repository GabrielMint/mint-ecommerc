package com.mint.ecommerce.business.sales.services

import com.mint.ecommerce.business.sales.model.Sale
import com.mint.ecommerce.business.sales.repositories.SalesRepository
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class SalesOrchestrator(
    private val salesRepository: SalesRepository
) {
    suspend fun createSale(sale: Sale) =
        salesRepository.createSale(sale)

    suspend fun getSale(saleId: UUID) =
        salesRepository.getSale(saleId)
}