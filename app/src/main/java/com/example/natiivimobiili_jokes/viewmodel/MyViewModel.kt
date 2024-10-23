package com.example.natiivimobiili_jokes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.natiivimobiili_jokes.model.JokesApi
import com.example.natiivimobiili_jokes.model.JokeResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed interface JokeUIState {
    data class Success(val joke: JokeResponse) : JokeUIState
    data object Error : JokeUIState
    data object Loading : JokeUIState
}

// Tämä säätelee tuon JokeUIStaten tilan
class MyViewModel : ViewModel() {
    private val _jokeUIState = MutableStateFlow<JokeUIState>(JokeUIState.Loading)
    val jokeUIState: StateFlow<JokeUIState> get() = _jokeUIState

    init {
        fetchRandomJoke()
    }

    fun fetchRandomJoke() {
        _jokeUIState.value = JokeUIState.Loading
        viewModelScope.launch {
            // shorthand, ? tarkottaa, että voi olla null
            val jokesApi: JokesApi?
            try {
                jokesApi = JokesApi.getInstance()
                // Suorittaa fetchin
                _jokeUIState.value = JokeUIState.Success(jokesApi.getRandomJoke())
            } catch (e: Exception) {
                _jokeUIState.value = JokeUIState.Error
            }
        }
    }
}