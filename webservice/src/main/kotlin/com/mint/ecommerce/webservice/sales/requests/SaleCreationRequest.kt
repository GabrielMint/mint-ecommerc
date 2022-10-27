package com.mint.ecommerce.webservice.sales.requests

import com.mint.ecommerce.business.sales.model.CartItem
import com.mint.ecommerce.business.sales.model.Sale
import java.time.Instant
import java.util.UUID

data class SaleCreationRequest(
    val totalAmount: Long,
    val cart: List<CartItemRequest>
    ) {
    fun toNewSale(): Sale {
        val saleId = UUID.randomUUID()
        return Sale (
            id = saleId,
            totalAmount = this.totalAmount,
            closedAt = Instant.now(),
            cart = this.cart.map {
                CartItem(
                    id = UUID.randomUUID(),
                    saleId = saleId,
                    productId = it.productId,
                    productQuantity = it.productQuantity,
                    subamount = it.subamount
                )
            }
        )
    }

}