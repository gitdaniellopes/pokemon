package br.com.daniellopes.pokemonpokeapi.kotlin.datasource.retrofit

import br.com.daniellopes.pokemonpokeapi.kotlin.datasource.retrofit.EndPoint.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonAPI {
    companion object {
        fun retrofit(): Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}