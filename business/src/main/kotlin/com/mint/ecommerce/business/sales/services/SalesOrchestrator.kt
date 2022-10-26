package com.mint.ecommerce.business.sales.services

import com.mint.ecommerce.business.sales.model.Sale
import com.mint.ecommerce.business.sales.repositories.SalesRepository
import org.springframework.stereotype.Component

@Component
class SalesOrchestrator(
    private val salesRepository: SalesRepository
) {
    suspend fun createSale(sale: Sale) =
        salesRepository.createSale(sale)
}