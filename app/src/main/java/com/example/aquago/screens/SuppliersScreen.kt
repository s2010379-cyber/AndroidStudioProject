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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SuppliersScreen(
    onBack: () -> Unit,
    onSupplierClick: (Supplier) -> Unit
) {

    var search by remember {
        mutableStateOf("")
    }

    val suppliers = listOf(
        Supplier(
            1,
            "Crystal Springs Purified",
            4.8,
            "1.2 km",
            "20-30 min",
            "$2.50 fee",
            "Alkaline Spring"
        ),
        Supplier(
            2,
            "Aqua Pure Delivery",
            4.5,
            "2.8 km",
            "30-45 min",
            "Free",
            "RO Filtered"
        ),
        Supplier(
            3,
            "Oasis Water Co.",
            4.2,
            "3.5 km",
            "45-60 min",
            "$1.00 fee",
            "Distilled Mineral"
        )
    )

    val filtered = suppliers.filter {
        it.name.contains(search, ignoreCase = true)
    }

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
            text = "Nearby Suppliers",
            style = androidx.compose.material3.MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(12.dp))

        OutlinedTextField(
            value = search,
            onValueChange = {
                search = it
            },
            label = {
                Text("Search for water suppliers...")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(12.dp))

        Text(
            text = "${filtered.size} results",
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(12.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(filtered) { supplier ->

                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Column(
                        modifier = Modifier.padding(18.dp)
                    ) {

                        Text(
                            text = supplier.name,
                            style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(Modifier.height(6.dp))

                        Row {
                            Text("★ ${supplier.rating}")

                            Spacer(Modifier.padding(horizontal = 8.dp))

                            Text(supplier.distance)
                        }

                        Text(supplier.waterType)

                        Text(supplier.deliveryTime)

                        Text(supplier.deliveryFee)

                        Spacer(Modifier.height(8.dp))

                        Button(
                            onClick = {
                                onSupplierClick(supplier)
                            }
                        ) {
                            Text("View Supplier")
                        }
                    }
                }
            }
        }
    }
}