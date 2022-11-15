package edu.miu.walmart.model

import java.io.Serializable

data class Product(
    val title: String,
    val price: String,
    val color: String,
    val image: Int,
    val itemId: Long,
    val desc: String,
) : Serializable