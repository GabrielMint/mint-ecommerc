package com.mint.ecommerce.business.sales.services

import com.mint.ecommerce.business.sales.model.Sale
import com.mint.ecommerce.business.sales.repositories.CartRepository
import com.mint.ecommerce.business.sales.repositories.SalesRepository
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class SalesOrchestrator(
    private val salesRepository: SalesRepository,
    private val cartRepository: CartRepository
) {
    suspend fun createSale(sale: Sale) {
        salesRepository.createSale(sale)
        sale.cart.forEach{ cartRepository.createCartItem(it) }
    }

    suspend fun getSale(saleId: UUID): Sale? {
        val sale = salesRepository.getSale(saleId)
            ?: return null
        return sale.copy(cart = cartRepository.getCartItemsBySale(sale.id))
    }

}