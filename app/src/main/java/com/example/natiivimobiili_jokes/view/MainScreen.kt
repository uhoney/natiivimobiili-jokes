package com.example.natiivimobiili_jokes.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.natiivimobiili_jokes.model.JokeResponse
import com.example.natiivimobiili_jokes.viewmodel.JokeUIState
import com.example.natiivimobiili_jokes.viewmodel.MyViewModel

@Composable
fun MainScreen(navController: NavController, screenTitle: String) {
    // viewModel instanssi
    val viewModel: MyViewModel = viewModel()
    // muuttuja; (loading, error, success) ja jos success; sen sisältämä data
    val uiState by viewModel.jokeUIState.collectAsState()

    Column {
        CustomTAB(navController, screenTitle)
        Column(modifier = Modifier.padding(8.dp)) {
            JokeScreen(uiState = uiState, fetchRandomJoke = viewModel::fetchRandomJoke)
        }
    }
}

// Vähän niinkuin tilakone
@Composable
fun JokeScreen(uiState: JokeUIState, fetchRandomJoke: () -> Unit = {}) {
    when (uiState) {
        is JokeUIState.Loading -> LoadingScreen()
        is JokeUIState.Success -> JokeDisplay(uiState.joke, fetchRandomJoke)
        is JokeUIState.Error -> ErrorScreen()
    }
}

@Composable
fun LoadingScreen() {
    Text("Loading")
}

@Composable
fun ErrorScreen() {
    Text("Error retrieving data from API!")
}

// Tässä ei mitään erikoista, muotoilua ja printtausta
@Composable
fun JokeDisplay(joke: JokeResponse, fetchRandomJoke: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = joke.setup, style = TextStyle(fontSize = 20.sp))
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = joke.punchline, style = TextStyle(fontSize = 20.sp))
        Spacer(Modifier.height(16.dp))
        Button(onClick = { fetchRandomJoke() }) {
            Text(text = "fetch again")
        }
    }
}