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
fun TrackingScreen(
    onBack: () -> Unit,
    onOrders: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Button(onClick = onBack) {
            Text("Back")
        }

        Text(
            text = "Tracking Order #8892",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(18.dp)
            ) {

                Text(
                    "12 mins",
                    style = MaterialTheme.typography.titleLarge
                )

                Text("Arriving at 10:45 AM")

                Spacer(Modifier.height(12.dp))

                Text(
                    "En Route",
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(18.dp)
            ) {

                Text(
                    "Michael T.",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Text("★ 4.9 (120+ deliveries)")

                Spacer(Modifier.height(8.dp))

                Text("3x Alkaline Spring Water (5G)")

                Text("Drop off at front door")
            }
        }

        Button(
            onClick = onOrders,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("View Orders")
        }
    }
}