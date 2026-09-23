package com.example.aquago.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

enum class AquaGoPage {
    HOME,
    PRODUCTS,
    SUPPLIERS,
    SUPPLIER_DETAILS,
    CART,
    CHECKOUT,
    TRACKING,
    ORDERS,
    NOTIFICATIONS,
    PROFILE
}

@Composable
fun AquaGoApp() {

    var currentPage by remember {
        mutableStateOf(AquaGoPage.HOME)
    }

    var selectedSupplier by remember {
        mutableStateOf<Supplier?>(null)
    }

    var cartItems by remember {
        mutableStateOf(
            listOf(
                CartItem(
                    Product(
                        1,
                        "5G Alkaline Spring Water",
                        "Alkaline",
                        14.99,
                        "Premium alkaline spring water"
                    ),
                    1
                )
            )
        )
    }

    when (currentPage) {

        AquaGoPage.HOME -> {
            HomeScreen(
                onProductsClick = {
                    currentPage = AquaGoPage.PRODUCTS
                },
                onSuppliersClick = {
                    currentPage = AquaGoPage.SUPPLIERS
                },
                onCartClick = {
                    currentPage = AquaGoPage.CART
                },
                onOrdersClick = {
                    currentPage = AquaGoPage.ORDERS
                },
                onProfileClick = {
                    currentPage = AquaGoPage.PROFILE
                },
                onNotificationsClick = {
                    currentPage = AquaGoPage.NOTIFICATIONS
                }
            )
        }

        AquaGoPage.PRODUCTS -> {
            ProductsScreen(
                onBack = {
                    currentPage = AquaGoPage.HOME
                },
                onCartClick = {
                    currentPage = AquaGoPage.CART
                },
                onAddToCart = { product ->
                    val existing = cartItems.find {
                        it.product.id == product.id
                    }

                    cartItems =
                        if (existing != null) {
                            cartItems.map {
                                if (it.product.id == product.id) {
                                    it.copy(quantity = it.quantity + 1)
                                } else {
                                    it
                                }
                            }
                        } else {
                            cartItems + CartItem(product, 1)
                        }
                }
            )
        }

        AquaGoPage.SUPPLIERS -> {
            SuppliersScreen(
                onBack = {
                    currentPage = AquaGoPage.HOME
                },
                onSupplierClick = { supplier ->
                    selectedSupplier = supplier
                    currentPage = AquaGoPage.SUPPLIER_DETAILS
                }
            )
        }

        AquaGoPage.SUPPLIER_DETAILS -> {
            selectedSupplier?.let { supplier ->

                SupplierDetailsScreen(
                    supplier = supplier,
                    onBack = {
                        currentPage = AquaGoPage.SUPPLIERS
                    },
                    onViewProducts = {
                        currentPage = AquaGoPage.PRODUCTS
                    }
                )
            }
        }

        AquaGoPage.CART -> {
            CartScreen(
                cartItems = cartItems,
                onBack = {
                    currentPage = AquaGoPage.HOME
                },
                onContinueShopping = {
                    currentPage = AquaGoPage.PRODUCTS
                },
                onCheckout = {
                    currentPage = AquaGoPage.CHECKOUT
                }
            )
        }

        AquaGoPage.CHECKOUT -> {
            CheckoutScreen(
                cartItems = cartItems,
                onBack = {
                    currentPage = AquaGoPage.CART
                },
                onPlaceOrder = {
                    currentPage = AquaGoPage.TRACKING
                }
            )
        }

        AquaGoPage.TRACKING -> {
            TrackingScreen(
                onBack = {
                    currentPage = AquaGoPage.HOME
                },
                onOrders = {
                    currentPage = AquaGoPage.ORDERS
                }
            )
        }

        AquaGoPage.ORDERS -> {
            OrdersScreen(
                onBack = {
                    currentPage = AquaGoPage.HOME
                },
                onTrackOrder = {
                    currentPage = AquaGoPage.TRACKING
                },
                onReorder = {
                    currentPage = AquaGoPage.CART
                }
            )
        }

        AquaGoPage.NOTIFICATIONS -> {
            NotificationsScreen(
                onBack = {
                    currentPage = AquaGoPage.HOME
                },
                onTrackOrder = {
                    currentPage = AquaGoPage.TRACKING
                }
            )
        }

        AquaGoPage.PROFILE -> {
            ProfileScreen(
                onBack = {
                    currentPage = AquaGoPage.HOME
                }
            )
        }
    }
}