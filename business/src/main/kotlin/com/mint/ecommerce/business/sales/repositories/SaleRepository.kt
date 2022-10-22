package com.mint.ecommerce.business.sales.repositories

import com.mint.ecommerce.business.sales.model.Sale
import java.util.UUID

interface SaleRepository {
    suspend fun createSale(sale: Sale)
    suspend fun getSale(id: UUID): Sale
}