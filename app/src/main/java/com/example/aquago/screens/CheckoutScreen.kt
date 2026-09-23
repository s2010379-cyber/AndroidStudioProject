package com.example.aquago.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CheckoutScreen(
    cartItems: List<CartItem>,
    onBack: () -> Unit,
    onPlaceOrder: () -> Unit
) {

    var expressDelivery by remember {
        mutableStateOf(true)
    }

    var cashOnDelivery by remember {
        mutableStateOf(true)
    }

    val subtotal = cartItems.sumOf {
        it.product.price * it.quantity
    }

    val deliveryFee =
        if (expressDelivery) 2.99 else 0.0

    val total = subtotal + deliveryFee

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Button(onClick = onBack) {
            Text("Back")
        }

        Spacer(Modifier.height(12.dp))

        Text(
            text = "Checkout",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(16.dp))

        Text(
            text = "Delivery Address",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    "Home",
                    fontWeight = FontWeight.Bold
                )

                Text("123 Aqua Street, Apt 4B")

                Text("Crystal Springs, CA 90210")
            }
        }

        Spacer(Modifier.height(16.dp))

        Text(
            text = "Delivery Schedule",
            fontWeight = FontWeight.Bold
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(12.dp)
            ) {

                RadioButton(
                    selected = expressDelivery,
                    onClick = {
                        expressDelivery = true
                    }
                )

                Text("Express (Now)")

                Text("Delivery in ~30 mins")

                Text("+$2.99 Fee")

                RadioButton(
                    selected = !expressDelivery,
                    onClick = {
                        expressDelivery = false
                    }
                )

                Text("Schedule Later")
            }
        }

        Spacer(Modifier.height(16.dp))

        Text(
            text = "Payment Method",
            fontWeight = FontWeight.Bold
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(12.dp)
            ) {

                RadioButton(
                    selected = cashOnDelivery,
                    onClick = {
                        cashOnDelivery = true
                    }
                )

                Text("Cash on Delivery")
            }
        }

        Spacer(Modifier.height(16.dp))

        Text("Subtotal: $${"%.2f".format(subtotal)}")

        Text("Delivery: $${"%.2f".format(deliveryFee)}")

        Text(
            "Total: $${"%.2f".format(total)}",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(12.dp))

        Button(
            onClick = onPlaceOrder,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Place Order - $${"%.2f".format(total)}")
        }
    }
}