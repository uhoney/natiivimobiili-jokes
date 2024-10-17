package com.example.natiivimobiili_jokes.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.natiivimobiili_jokes.R
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController, screenTitle: String) {
    Column {
        CustomTAB(navController, screenTitle)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                stringResource(R.string.main_text),
                style = TextStyle(fontSize = 20.sp)
            )
            Button(onClick = { /*TODO*/ }) {
                Text(stringResource(R.string.button_fetch_joke))
            }
        }
    }
}