package com.example.aquago

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.aquago.screens.AquaGoApp
import com.example.aquago.screens.LoginScreen
import com.example.aquago.ui.theme.AquaGoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            AquaGoTheme {

                var loggedIn by remember {
                    mutableStateOf(false)
                }

                if (loggedIn) {

                    AquaGoApp()

                } else {

                    LoginScreen(
                        onLoginSuccess = {
                            loggedIn = true
                        }
                    )
                }
            }
        }
    }
}