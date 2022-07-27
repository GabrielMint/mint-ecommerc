package com.mint.ecommerce.business.sales.model

import java.util.UUID

data class Sale (
    val id: UUID,
    val cart: List<CartItem>
    )


data class CartItem(
    val id: UUID,
    val saleId: UUID,
    val productId: UUID,
    val productQuantity: Int,
    val subtotal: Long
)