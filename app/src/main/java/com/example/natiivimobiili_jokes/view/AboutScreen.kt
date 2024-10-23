package com.example.natiivimobiili_jokes.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.natiivimobiili_jokes.R
import androidx.navigation.NavController

@Composable
fun AboutScreen(navController: NavController, screenTitle: String) {
    Column {
        CustomTAB(navController, screenTitle)
        Column(modifier = Modifier.padding(16.dp))
        {
            Text(stringResource(R.string.about_info))
        }
    }
}