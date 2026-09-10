package com.example.dao.Model

data class Imc(
    val peso: Double = 0.0,
    val altura: Double = 0.0
) {
    fun calcularImc(): Double {
        return peso / (altura * altura)
    }
}
