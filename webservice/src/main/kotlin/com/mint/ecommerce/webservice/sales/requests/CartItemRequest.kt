package com.mint.ecommerce.webservice.sales.requests

import java.util.UUID

data class CartItemRequest(
    val productId: UUID,
    val productQuantity: Int,
    val subamount: Long
)