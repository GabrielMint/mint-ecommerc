package com.mint.ecommerce.database.r2dbc.cart

import com.mint.ecommerce.database.r2dbc.sales.SaleSqlExpressions

object CartSqlExpressions {

    private const val TABLE_NAME = "Sale_Products"

    const val INSERT_SALE_PRODUCT = """
        INSERT INTO $TABLE_NAME
        (
            id,
            sale_id,
            product_id,
            product_quantity,
            subamount
        )
        VALUES
        (
            :id,
            :saleId,
            :productId,
            :productQuantity,
            :subamount
        )
    """

    const val RETRIEVE_SALE_PRODUCT = """
        SELECT
            id,
            sale_id,
            product_id,
            product_quantity,
            subamount
        FROM
            $TABLE_NAME
        WHERE sale_id = :saleId
    """

}