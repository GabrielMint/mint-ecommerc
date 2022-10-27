package com.mint.ecommerce.business.sales.model

import java.time.Instant
import java.util.UUID

data class Sale (
    val id: UUID,
    val totalAmount: Long,
    val closedAt: Instant,
    val cart: List<CartItem>
    )

data class CartItem(
    val id: UUID,
    val saleId: UUID,
    val productId: UUID,
    val productQuantity: Int,
    val subamount: Long
)