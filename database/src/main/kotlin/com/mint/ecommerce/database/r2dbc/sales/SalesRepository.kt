package com.mint.ecommerce.database.r2dbc.sales

import com.mint.ecommerce.business.sales.model.Sale
import com.mint.ecommerce.business.sales.repositories.SalesRepository
import com.mint.ecommerce.database.r2dbc.extensions.get
import io.r2dbc.spi.Row
import mu.KLogging
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.r2dbc.core.await
import org.springframework.r2dbc.core.awaitSingle
import org.springframework.stereotype.Repository
import java.time.Instant
import java.util.UUID

@Repository
class SalesRepository(
    private val db: DatabaseClient
): SalesRepository {

    companion object : KLogging()

    override suspend fun createSale(sale: Sale)  {
        logger.info { "Creating sale with id [${sale.id}]" }

        db.sql(SaleSqlExpressions.INSERT_SALE)
            .bind("id", sale.id)
            .bind("totalAmount", sale.totalAmount)
            .bind("closedAt", sale.closedAt)
            .await()
    }

    override suspend fun getSale(id: UUID): Sale? =
        db.sql(SaleSqlExpressions.RETRIEVE_SALE)
            .bind("id", id)
            .map{row, _ -> row.toSale()}
            .awaitSingle()

    private fun Row.toSale() =
        Sale(
            id = this.get<UUID>("id"),
            closedAt = this.get<Instant>("closed_at"),
            totalAmount = this.get<Long>("total_amount"),
            cart = emptyList()
        )
}