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
fun OrdersScreen(
    onBack: () -> Unit,
    onTrackOrder: () -> Unit,
    onReorder: () -> Unit
) {

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
            "Order History",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Text("Review and manage your past deliveries.")

        Spacer(Modifier.height(16.dp))

        OrderCard(
            orderNumber = "#8492",
            date = "Oct 24, 2023",
            item = "Alkaline Spring Water 5G x2",
            status = "In Progress",
            total = "$34.50",
            actionText = "Track",
            action = onTrackOrder
        )

        Spacer(Modifier.height(12.dp))

        OrderCard(
            orderNumber = "#8105",
            date = "Oct 10, 2023",
            item = "Dispenser Filter x4 / Purified Water 3G x1",
            status = "Delivered",
            total = "$42.00",
            actionText = "Reorder",
            action = onReorder
        )

        Spacer(Modifier.height(12.dp))

        OrderCard(
            orderNumber = "#922",
            date = "Oct 2, 2023",
            item = "Alkaline Spring Water 5G x2",
            status = "Delivered",
            total = "$34.50",
            actionText = "Reorder",
            action = onReorder
        )
    }
}

@Composable
private fun OrderCard(
    orderNumber: String,
    date: String,
    item: String,
    status: String,
    total: String,
    actionText: String,
    action: () -> Unit
) {

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                "ORDER $orderNumber",
                fontWeight = FontWeight.Bold
            )

            Text(date)

            Spacer(Modifier.height(6.dp))

            Text(item)

            Spacer(Modifier.height(6.dp))

            Text(status)

            Spacer(Modifier.height(6.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    "TOTAL $total",
                    fontWeight = FontWeight.Bold
                )

                Button(onClick = action) {
                    Text(actionText)
                }
            }
        }
    }
}