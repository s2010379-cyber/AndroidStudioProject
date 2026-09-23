package com.example.aquago.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CartScreen(
    cartItems: List<CartItem>,
    onBack: () -> Unit,
    onContinueShopping: () -> Unit,
    onCheckout: () -> Unit
) {

    val subtotal = cartItems.sumOf {
        it.product.price * it.quantity
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Button(onClick = onBack) {
            Text("Back")
        }

        Spacer(Modifier.height(16.dp))

        Text(
            text = "Shopping Cart",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(16.dp))

        cartItems.forEach { item ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp)
            ) {

                Row(
                    modifier = Modifier.padding(18.dp)
                ) {

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            item.product.name,
                            fontWeight = FontWeight.Bold
                        )

                        Text("Quantity: ${item.quantity}")

                        Text(
                            "$${"%.2f".format(item.product.price * item.quantity)}"
                        )
                    }
                }
            }
        }

        Spacer(Modifier.height(10.dp))

        Text(
            text = "Subtotal: $${"%.2f".format(subtotal)}",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = onContinueShopping,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Continue Shopping")
        }

        Spacer(Modifier.height(8.dp))

        Button(
            onClick = onCheckout,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Proceed to Checkout")
        }
    }
}