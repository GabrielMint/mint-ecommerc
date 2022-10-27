package com.mint.ecommerce.database.r2dbc.cart

import com.mint.ecommerce.business.sales.model.CartItem
import com.mint.ecommerce.business.sales.repositories.CartRepository
import com.mint.ecommerce.database.r2dbc.extensions.get
import io.r2dbc.spi.Row
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.reactive.asFlow
import mu.KLogging
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.r2dbc.core.await
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class CartRepository(
    private val db: DatabaseClient
): CartRepository {

    companion object : KLogging()

    override suspend fun getCartItemsBySale(saleId: UUID) =
        db.sql(CartSqlExpressions.RETRIEVE_SALE_PRODUCT)
            .bind("saleId", saleId)
            .map{ row, _ -> row.toCartItem() }
            .all()
            .asFlow()
            .toList()

    override suspend fun createCartItem(cartItem: CartItem) {

        logger.info { "Creating new cart item with id [${cartItem.id}] for sale [${cartItem.saleId}]" }

        db.sql(CartSqlExpressions.INSERT_SALE_PRODUCT)
            .bind("id", cartItem.id)
            .bind("saleId", cartItem.saleId)
            .bind("productId", cartItem.productId)
            .bind("productQuantity", cartItem.productQuantity)
            .bind("subamount", cartItem.subamount)
            .await()
    }


    fun Row.toCartItem() =
        CartItem(
            id = this.get<UUID>("id"),
            saleId = this.get<UUID>("sale_id"),
            productId = this.get<UUID>("product_id"),
            productQuantity = this.get<Int>("product_quantity"),
            subamount = this.get<Long>("subamount")
        )

}