package com.example.natiivimobiili_jokes.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.natiivimobiili_jokes.ui.theme.MyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTAB() {
    TopAppBar(
        title = { Text("Jokes :)") },
        colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.primary),
        actions = {
            IconButton(onClick = { }) {
                Icon(Icons.Default.Settings, contentDescription = "Settings screen")
            }
        }
    )
}