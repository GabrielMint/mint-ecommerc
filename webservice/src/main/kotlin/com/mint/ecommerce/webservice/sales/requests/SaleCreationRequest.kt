package com.mint.ecommerce.webservice.sales.requests

import java.util.UUID

data class SaleCreationRequest(
    val cart: List<CartItemRequest>
    )