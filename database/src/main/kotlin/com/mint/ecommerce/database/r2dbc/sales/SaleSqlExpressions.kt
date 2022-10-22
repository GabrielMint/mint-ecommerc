package com.mint.ecommerce.database.r2dbc.sales

object SaleSqlExpressions {

    private const val TABLE_NAME = "Sales"

    const val INSERT_SALE = """
        INSERT INTO $TABLE_NAME
        (
            id,
            closedAt
        )
        VALUES
        (
            :id,
            :closedAt
        )
    """

    const val RETRIEVE_SALE = """
        SELECT
            id,
            closedAt
        FROM
            $TABLE_NAME
        WHERE id = id:
    """


}