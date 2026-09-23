package com.example.aquago.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ProductsScreen(
    onBack: () -> Unit,
    onCartClick: () -> Unit,
    onAddToCart: (Product) -> Unit
) {

    val products = listOf(
        Product(
            1,
            "5G Alkaline Spring Water",
            "Alkaline",
            14.99,
            "Premium alkaline spring water"
        ),
        Product(
            2,
            "5G Purified Water",
            "Purified",
            11.99,
            "Clean purified drinking water"
        ),
        Product(
            3,
            "3G Mineral Water",
            "Mineral",
            9.99,
            "Refreshing mineral water"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Button(onClick = onBack) {
                Text("Back")
            }

            Button(onClick = onCartClick) {
                Text("Cart")
            }
        }

        Spacer(Modifier.height(20.dp))

        Text(
            text = "Water Products",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {

            items(products) { product ->

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(18.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(18.dp)
                    ) {

                        Text(
                            text = product.name,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = product.type
                        )

                        Spacer(Modifier.height(6.dp))

                        Text(
                            text = product.description
                        )

                        Spacer(Modifier.height(8.dp))

                        Text(
                            text = "$${"%.2f".format(product.price)}",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(Modifier.height(8.dp))

                        Button(
                            onClick = {
                                onAddToCart(product)
                            }
                        ) {
                            Text("Add to Cart")
                        }
                    }
                }
            }
        }
    }
}