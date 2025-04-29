package com.example.tienda

data class Producto(
    val id: Int,
    val nombre: String,
    val precioUnitario: Double,
    val cantidad: Int,
    val descripcion: String,
    val imagenUrl: String
) {
    val precioTotal: Double
        get() = precioUnitario * cantidad
}
