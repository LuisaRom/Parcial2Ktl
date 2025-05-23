package com.example.tienda

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.NavHostController
import com.example.tienda.Pantallas.*

@Composable
fun AppNavigation(navController: NavHostController, viewModel: ProductoViewModel) {
    NavHost(navController = navController, startDestination = "catalogo") {
        composable("catalogo") {
            PantallaPrincipal(
                productos = viewModel.productos,
                carrito = viewModel.carrito,
                navController = navController
            )
        }

        composable("registro") {
            PantallaRegistro(
                onAgregarProducto = {
                    viewModel.agregarProducto(it)
                    navController.popBackStack()
                },
                onCancelar = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            "detalle/{productoId}",
            arguments = listOf(navArgument("productoId") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("productoId")
            PantallaDetalles(
                productoId = id,
                productos = viewModel.productos,
                onAgregarAlCarrito = {
                    viewModel.agregarAlCarrito(it)
                },
                onVolver = {
                    navController.popBackStack()
                }
            )
        }

        composable("carrito") {
            PantallaCarrito(
                carrito = viewModel.carrito,
                onFinalizarCompra = {
                    viewModel.limpiarCarrito()
                },
                onVolver = {
                    navController.popBackStack()
                }
            )
        }
    }
}