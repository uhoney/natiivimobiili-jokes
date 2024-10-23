package com.example.natiivimobiili_jokes.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.natiivimobiili_jokes.R
import com.example.natiivimobiili_jokes.ui.theme.MyTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .systemBarsPadding()
                ) {
                    JokesApp()
                }
            }
        }
    }
}

@Composable
fun JokesApp() {
    val navController = rememberNavController()

    // Statusbar teeman mukaiseksi
    val systemUiController = rememberSystemUiController()
    // Näitä ei hyväksy suoraan sideeffectiin? luulevat olevansa composablen ulkopuolella.
    val usingDarkTheme = !isSystemInDarkTheme()
    val primaryColor = MaterialTheme.colorScheme.primaryContainer

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = primaryColor,
            darkIcons = usingDarkTheme
        )
    }

    // Navhostin määrittely ja annetaan ruudun nimi stringresourcena
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen(
                navController,
                stringResource(R.string.nav_title_main)
            )
        }
        composable("about") {
            AboutScreen(
                navController,
                stringResource(R.string.nav_title_about)
            )
        }
    }
}
