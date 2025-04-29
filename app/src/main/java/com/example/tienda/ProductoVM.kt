package com.example.tienda

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class ProductoViewModel : ViewModel() {
    val productos = mutableStateListOf<Producto>()
    val carrito = mutableStateListOf<Producto>()

    fun agregarProducto(producto: Producto) {
        productos.add(producto)
    }

    fun agregarAlCarrito(producto: Producto) {
        carrito.add(producto)
    }

    fun limpiarCarrito() {
        carrito.clear()
    }
}