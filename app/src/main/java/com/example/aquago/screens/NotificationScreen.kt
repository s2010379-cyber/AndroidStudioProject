package com.example.aquago.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class NotificationItem(
    val title: String,
    val message: String,
    val time: String
)

@Composable
fun NotificationsScreen(
    onBack: () -> Unit,
    onTrackOrder: () -> Unit
) {

    val notifications = listOf(

        NotificationItem(
            "Order #123 is on its way",
            "Your delivery is currently out for delivery.",
            "10:42 AM"
        ),

        NotificationItem(
            "Time to reorder",
            "Based on your consumption pattern, it's time to reorder your 5G water.",
            "9:00 AM"
        ),

        NotificationItem(
            "Weekend Special Offer",
            "Get 15% off all mineral water subscriptions.",
            "Yesterday"
        ),

        NotificationItem(
            "Payment Successful",
            "Your payment for Order #1 was processed successfully.",
            "Yesterday"
        )
    )

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
            "Notifications",
            fontWeight = FontWeight.Bold
        )

        Text("Stay updated with your deliveries and tips.")

        Spacer(Modifier.height(16.dp))

        LazyColumn {

            items(notifications) { notification ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            notification.title,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(Modifier.height(4.dp))

                        Text(notification.message)

                        Spacer(Modifier.height(4.dp))

                        Text(notification.time)

                        if (notification.title.contains("way")) {

                            Button(
                                onClick = onTrackOrder
                            ) {
                                Text("Track Order")
                            }
                        }
                    }
                }
            }
        }
    }
}