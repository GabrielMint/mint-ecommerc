package com.mint.ecommerce.database.r2dbc.extensions

import io.r2dbc.spi.Row

@Suppress("EXTENSION_SHADOWED_BY_MEMBER")
inline fun <reified T : Any> Row.get(identifier: String): T = this.get(identifier, T::class.java)!!

@Suppress("EXTENSION_SHADOWED_BY_MEMBER")
inline fun <reified T : Enum<T>> Row.getEnum(identifier: String): T {
    val value = this.get(identifier, String::class.java)!!
    enumValues<T>().iterator().forEach {
        if (it.name == value) return it
    }
    throw IllegalStateException("Trying to find [$value] but not found on enum [${T::class.java}]")
}

@Suppress("EXTENSION_SHADOWED_BY_MEMBER")
inline fun <reified T : Enum<T>> Row.getEnumOrNull(identifier: String): T? {
    val value = this.getOrNull<String>(identifier) ?: return null
    enumValues<T>().iterator().forEach {
        if (it.name == value) return it
    }
    throw IllegalStateException("Trying to find [$value] but not found on enum [${T::class.java}]")
}

inline fun <reified T : Any> Row.getOrNull(identifier: String): T? = this.get(identifier, T::class.java)