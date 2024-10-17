package com.example.natiivimobiili_jokes.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.natiivimobiili_jokes.R
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController, screenTitle: String) {
    Scaffold(
        topBar = { CustomTAB(navController, screenTitle) },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                
            }
        }
    )
}