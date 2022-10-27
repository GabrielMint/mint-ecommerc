package com.mint.ecommerce.business.sales.repositories

import com.mint.ecommerce.business.sales.model.CartItem
import java.util.UUID

interface CartRepository {
    suspend fun getCartItemsBySale(saleId: UUID): List<CartItem>
    suspend fun createCartItem(cartItem: CartItem)
}