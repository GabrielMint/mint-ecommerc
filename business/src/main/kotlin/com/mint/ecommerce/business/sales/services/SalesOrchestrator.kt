package com.mint.ecommerce.business.sales.services

import com.mint.ecommerce.business.sales.model.Sale
import com.mint.ecommerce.business.sales.repositories.SaleRepository
import org.springframework.stereotype.Service

@Service
class SalesOrchestrator(
    private val saleRepository: SaleRepository
) {
    suspend fun createSale(sale: Sale) =
        saleRepository.createSale(sale)
}