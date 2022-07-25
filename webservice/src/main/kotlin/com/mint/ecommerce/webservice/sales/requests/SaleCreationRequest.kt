package com.mint.ecommerce.webservice.sales.requests

data class SaleCreationRequest(
    val totalAmount: Long,
    val cart: List<CartItemRequest>
    )