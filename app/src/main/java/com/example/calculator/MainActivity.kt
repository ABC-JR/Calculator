package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.calculator.Screen.Main
import com.example.calculator.Screen.Screen2


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val trushlist = mutableMapOf<String  , String>()
            val controller = rememberNavController()
            NavHost(navController = controller, startDestination = "screen1") {
                    composable("screen1") {
                        Main (trushlist){
                            controller.navigate("screen2")
                        }
                    }
                    composable("screen2") {
                        Screen2(trushlist) {
                            controller.navigate("screen1"){
                                popUpTo("screen1"){
                                    inclusive = true
                                }
                            }
                        }
                    }

                }

        }
    }
}
