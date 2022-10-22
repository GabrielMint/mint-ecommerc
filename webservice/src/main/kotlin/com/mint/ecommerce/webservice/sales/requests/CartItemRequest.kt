package com.mint.ecommerce.webservice.sales.requests

import com.mint.ecommerce.business.sales.model.CartItem
import java.util.UUID

data class CartItemRequest(
    val productId: UUID,
    val productQuantity: Int,
    val subtotal: Long
)