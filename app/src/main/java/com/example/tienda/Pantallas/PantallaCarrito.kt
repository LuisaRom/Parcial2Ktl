package com.example.tienda.Pantallas

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.tienda.Producto
import com.example.tienda.R

@Composable
fun PantallaCarrito(
    carrito: List<Producto>,
    onFinalizarCompra: () -> Unit,
    onVolver: () -> Unit
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Text(
            text = "Carrito de Compras",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (carrito.isEmpty()) {
            Text("El carrito está vacío", color = MaterialTheme.colorScheme.onBackground)
        } else {
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(carrito.size) { index ->
                    val producto = carrito[index]
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter(
                                    model = producto.imagenUrl,
                                    placeholder = painterResource(R.drawable.cargando),
                                    error = painterResource(R.drawable.error)
                                ),
                                contentDescription = producto.nombre,
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(RoundedCornerShape(8.dp))
                            )

                            Spacer(modifier = Modifier.width(12.dp))

                            Column {
                                Text(producto.nombre, style = MaterialTheme.typography.titleSmall)
                                Text(
                                    "Precio: $${producto.precioTotal}",
                                    color = MaterialTheme.colorScheme.secondary
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Total a Pagar: $${String.format("%.2f", carrito.sumOf { it.precioTotal })}",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.align(Alignment.End),
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        onFinalizarCompra()
                        Toast.makeText(context, "¡Compra finalizada exitosamente!", Toast.LENGTH_LONG).show()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text("Finalizar Compra", color = MaterialTheme.colorScheme.onPrimary)
                }

                Button(
                    onClick = { onVolver() },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
                ) {
                    Text("Volver", color = MaterialTheme.colorScheme.onSecondary)
                }
            }
        }
    }
}