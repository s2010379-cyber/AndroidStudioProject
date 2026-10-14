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
import androidx.compose.foundation.layout.navigationBarsPadding
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


// =====================================================
// HOME SCREEN
// =====================================================

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
            .background(
                MaterialTheme.colorScheme.background
            )
    ) {

        // =====================================================
        // MAIN HOME CONTENT
        // =====================================================

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(
                    rememberScrollState()
                )
                .padding(
                    start = 20.dp,
                    end = 20.dp,
                    top = 20.dp
                )
        ) {

            // APP NAME
            Text(
                text = "AquaGo",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )


            // DELIVERY ADDRESS
            Text(
                text = "Delivering to",
                style = MaterialTheme.typography.labelLarge
            )

            Text(
                text = "123 Waterway Blvd",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )


            // =====================================================
            // SMART REORDER
            // =====================================================

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor =
                        MaterialTheme.colorScheme.primaryContainer
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

                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )

                    Text(
                        text = "Looks like you're running low on Alkaline Water."
                    )

                    Text(
                        text = "Reorder now?"
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(
                        text = "5G Alkaline Jug",
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Last ordered 12 days ago"
                    )

                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )

                    Text(
                        text = "$14.99",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
            }


            Spacer(
                modifier = Modifier.height(24.dp)
            )


            // =====================================================
            // FEATURED SUPPLIERS
            // =====================================================

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement =
                    Arrangement.SpaceBetween,
                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Text(
                    text = "Featured Suppliers",
                    style =
                        MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "See All",
                    modifier = Modifier.clickable {
                        onSuppliersClick()
                    },
                    color =
                        MaterialTheme.colorScheme.primary
                )
            }


            Spacer(
                modifier = Modifier.height(12.dp)
            )


            // SUPPLIER 1

            SupplierPreviewCard(
                name = "Crystal Springs Local",
                rating = "4.9",
                deliveryTime = "20-30 min",
                deliveryFee = "Free Delivery",
                onClick = onSuppliersClick
            )


            Spacer(
                modifier = Modifier.height(12.dp)
            )


            // SUPPLIER 2

            SupplierPreviewCard(
                name = "AquaPure Depot",
                rating = "4.7",
                deliveryTime = "45-60 min",
                deliveryFee = "$2.99 Fee",
                onClick = onSuppliersClick
            )


            Spacer(
                modifier = Modifier.height(24.dp)
            )


            // =====================================================
            // PRODUCTS
            // =====================================================

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
                        style =
                            MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )

                    Text(
                        text =
                            "Find purified, alkaline, mineral and filtered water."
                    )
                }
            }


            // Space above bottom navigation

            Spacer(
                modifier = Modifier.height(20.dp)
            )
        }


        // =====================================================
        // FIXED BOTTOM NAVIGATION
        // =====================================================

        AquaGoBottomBar(
            onHome = {
                // Already on Home
            },

            onExplore = onSuppliersClick,

            onOrders = onOrdersClick,

            onCart = onCartClick,

            onProfile = onProfileClick,

            onNotifications = onNotificationsClick
        )
    }
}


// =====================================================
// SUPPLIER CARD
// =====================================================

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
                style =
                    MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(6.dp)
            )

            Row(
                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Text(
                    text = "★ $rating"
                )

                Spacer(
                    modifier = Modifier.width(16.dp)
                )

                Text(
                    text = deliveryTime
                )
            }

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = deliveryFee
            )
        }
    }
}


// =====================================================
// AQUAGO BOTTOM NAVIGATION
// =====================================================

@Composable
fun AquaGoBottomBar(
    onHome: () -> Unit,
    onExplore: () -> Unit,
    onOrders: () -> Unit,
    onCart: () -> Unit,
    onProfile: () -> Unit,
    onNotifications: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.surface
            )
            .navigationBarsPadding()
            .padding(
                top = 10.dp,
                bottom = 10.dp
            ),

        horizontalArrangement =
            Arrangement.SpaceEvenly,

        verticalAlignment =
            Alignment.CenterVertically
    ) {


        // HOME

        NavigationItem(
            symbol = "⌂",
            label = "Home",
            onClick = onHome
        )


        // EXPLORE

        NavigationItem(
            symbol = "◉",
            label = "Explore",
            onClick = onExplore
        )


        // ORDERS

        NavigationItem(
            symbol = "🛒",
            label = "Orders",
            onClick = onOrders
        )


        // NOTIFICATIONS

        NavigationItem(
            symbol = "🔔",
            label = "Alerts",
            onClick = onNotifications
        )


        // PROFILE

        NavigationItem(
            symbol = "●",
            label = "Profile",
            onClick = onProfile
        )
    }
}


// =====================================================
// NAVIGATION ITEM
// =====================================================

@Composable
private fun NavigationItem(
    symbol: String,
    label: String,
    onClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .clickable {
                onClick()
            }
            .padding(
                horizontal = 8.dp,
                vertical = 4.dp
            ),

        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {

        Text(
            text = symbol,
            style =
                MaterialTheme.typography.titleMedium
        )

        Spacer(
            modifier = Modifier.height(2.dp)
        )

        Text(
            text = label,
            style =
                MaterialTheme.typography.labelSmall
        )
    }
}