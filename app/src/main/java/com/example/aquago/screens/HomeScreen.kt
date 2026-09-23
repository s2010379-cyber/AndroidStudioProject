package com.example.aquago.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onProductsClick: () -> Unit,
    onSuppliersClick: () -> Unit,
    onCartClick: () -> Unit,
    onOrdersClick: () -> Unit,
    onProfileClick: () -> Unit,
    onNotificationsClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {

            Text(
                text = "AquaGo",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(20.dp))

            Text(
                text = "Delivering to",
                style = MaterialTheme.typography.labelLarge
            )

            Text(
                text = "123 Waterway Blvd",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(20.dp))

            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {

                Column(
                    modifier = Modifier.padding(18.dp)
                ) {

                    Text(
                        text = "Smart Reorder",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(Modifier.height(6.dp))

                    Text(
                        text = "Looks like you're running low on Alkaline Water. Reorder now?"
                    )

                    Spacer(Modifier.height(12.dp))

                    Text(
                        text = "5G Alkaline Jug",
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Last ordered 12 days ago"
                    )

                    Spacer(Modifier.height(6.dp))

                    Text(
                        text = "$14.99",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Featured Suppliers",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "See All",
                    modifier = Modifier.clickable {
                        onSuppliersClick()
                    }
                )
            }

            Spacer(Modifier.height(12.dp))

            SupplierPreviewCard(
                name = "Crystal Springs Local",
                rating = "4.9",
                deliveryTime = "20-30 min",
                deliveryFee = "Free Delivery",
                onClick = onSuppliersClick
            )

            Spacer(Modifier.height(12.dp))

            SupplierPreviewCard(
                name = "AquaPure Depot",
                rating = "4.7",
                deliveryTime = "45-60 min",
                deliveryFee = "$2.99 Fee",
                onClick = onSuppliersClick
            )

            Spacer(Modifier.height(24.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onProductsClick()
                    },
                shape = RoundedCornerShape(18.dp)
            ) {

                Column(
                    modifier = Modifier.padding(18.dp)
                ) {

                    Text(
                        text = "Browse Water Products",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Find purified, alkaline, mineral and filtered water."
                    )
                }
            }
        }

        BottomNavigationBar(
            onHome = {},
            onExplore = onSuppliersClick,
            onOrders = onOrdersClick,
            onProfile = onProfileClick,
            onNotifications = onNotificationsClick
        )
    }
}

@Composable
private fun SupplierPreviewCard(
    name: String,
    rating: String,
    deliveryTime: String,
    deliveryFee: String,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(18.dp)
    ) {

        Column(
            modifier = Modifier.padding(18.dp)
        ) {

            Text(
                text = name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(6.dp))

            Row {

                Text(text = "★ $rating")

                Spacer(Modifier.width(16.dp))

                Text(text = deliveryTime)
            }

            Spacer(Modifier.height(4.dp))

            Text(text = deliveryFee)
        }
    }
}

@Composable
fun BottomNavigationBar(
    onHome: () -> Unit,
    onExplore: () -> Unit,
    onOrders: () -> Unit,
    onProfile: () -> Unit,
    onNotifications: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        Text(
            text = "Home",
            modifier = Modifier.clickable { onHome() }
        )

        Text(
            text = "Explore",
            modifier = Modifier.clickable { onExplore() }
        )

        Text(
            text = "Orders",
            modifier = Modifier.clickable { onOrders() }
        )

        Text(
            text = "Profile",
            modifier = Modifier.clickable { onProfile() }
        )
    }
}