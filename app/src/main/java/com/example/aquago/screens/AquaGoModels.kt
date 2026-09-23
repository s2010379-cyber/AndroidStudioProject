package com.example.aquago.screens

data class Product(
    val id: Int,
    val name: String,
    val type: String,
    val price: Double,
    val description: String = "",
    val quantity: Int = 1
)

data class Supplier(
    val id: Int,
    val name: String,
    val rating: Double,
    val distance: String,
    val deliveryTime: String,
    val deliveryFee: String,
    val waterType: String
)

data class CartItem(
    val product: Product,
    val quantity: Int
)