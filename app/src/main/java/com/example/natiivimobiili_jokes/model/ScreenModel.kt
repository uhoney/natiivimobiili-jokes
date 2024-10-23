package com.example.natiivimobiili_jokes.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class JokeResponse(
    val setup: String,
    val punchline: String
)

const val BASE_URL = "https://official-joke-api.appspot.com/"

interface JokesApi {
    @GET("random_joke")
    suspend fun getRandomJoke(): JokeResponse

    companion object {
        private var jokesService: JokesApi? = null

        // retrofit & gson boilerplate koodi, rakentaa JokesApin
        fun getInstance(): JokesApi {
            // Jos se instanssi on null niin se rakennetaan
            if (jokesService == null) {
                jokesService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(JokesApi::class.java)
            }
            return jokesService!!
        }
    }
}