package br.com.daniellopes.pokemonpokeapi.kotlin.datasource.retrofit

import br.com.daniellopes.pokemonpokeapi.kotlin.model.Pokemon
import br.com.daniellopes.pokemonpokeapi.kotlin.model.PokemonDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EndPoint {

    companion object {
        const val BASE_URL = "https://pokemon-favorite.herokuapp.com/"
    }

    @GET("pokemon")
    fun findAll(): Call<List<Pokemon>>

    @GET("pokemon/{id}")
    fun findPokemonBy(@Path("id") id: Int): Call<PokemonDetail>
}