package com.example.g10_hamburgueria

data class Perfil(
    val username: String,
    val password: String,
    val address : String,
    val phoneNumber: String,
    val email: String,
    val cardNumber: String,
    val cardBrand: String,
    val cardHolderName: String,
    val cardExpiryDate: String,
    val cardCVV: String
)