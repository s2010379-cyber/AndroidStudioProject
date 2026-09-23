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
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SupplierDetailsScreen(
    supplier: Supplier,
    onBack: () -> Unit,
    onViewProducts: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {

        Button(onClick = onBack) {
            Text("Back")
        }

        Text(
            text = supplier.name,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(18.dp)
            ) {

                Text("★ ${supplier.rating}")

                Text("${supplier.distance} away")

                Text(supplier.waterType)

                Text(supplier.deliveryTime)

                Text(supplier.deliveryFee)
            }
        }

        Text(
            text = "Available Water Products",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Button(
            onClick = onViewProducts,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("View Products")
        }
    }
}