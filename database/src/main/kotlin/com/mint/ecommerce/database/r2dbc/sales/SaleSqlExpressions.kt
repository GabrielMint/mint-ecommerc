package com.mint.ecommerce.database.r2dbc.sales

object SaleSqlExpressions {

    private const val TABLE_NAME = "Sales"

    const val INSERT_SALE = """
        INSERT INTO $TABLE_NAME
        (
            id,
            total_amount,
            closed_at
        )
        VALUES
        (
            :id,
            :totalAmount,
            :closedAt
        )
    """

    const val RETRIEVE_SALE = """
        SELECT
            id,
            total_amount,
            closed_at
        FROM
            $TABLE_NAME
        WHERE id = :id
    """


}