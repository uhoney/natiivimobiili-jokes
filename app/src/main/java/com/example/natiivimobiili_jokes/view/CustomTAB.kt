package com.example.natiivimobiili_jokes.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTAB(navController: NavController, screenTitle: String) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    TopAppBar(
        title = { Text(screenTitle) },
        colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.primaryContainer),
        navigationIcon = {
            if (currentRoute == "about") {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                }
            }
        },
        actions = {
            if (currentRoute != "about") {
                IconButton(
                    onClick = {
                        navController.navigate("about")
                    })
                {
                    Icon(Icons.Default.Info, contentDescription = "About screen")
                }
            }
        }
    )
}