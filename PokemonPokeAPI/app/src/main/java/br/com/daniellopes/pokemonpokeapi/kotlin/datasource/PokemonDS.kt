package br.com.daniellopes.pokemonpokeapi.kotlin.datasource

import br.com.daniellopes.pokemonpokeapi.kotlin.datasource.retrofit.EndPoint
import br.com.daniellopes.pokemonpokeapi.kotlin.datasource.retrofit.PokemonAPI
import br.com.daniellopes.pokemonpokeapi.kotlin.interfaces.PokemonC
import br.com.daniellopes.pokemonpokeapi.kotlin.model.Pokemon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonDS {
    fun findAll(callback: PokemonC) {
        PokemonAPI.retrofit().create(EndPoint::class.java)
                .findAll().enqueue(object : Callback<List<Pokemon>> {
                    override fun onFailure(call: Call<List<Pokemon>>, t: Throwable) {
                        t.message?.let { error ->
                            callback.onError(error)
                        }
                    }

                    override fun onResponse(call: Call<List<Pokemon>>, response: Response<List<Pokemon>>) {
                        if (response.isSuccessful) {
                            response.body()?.let { pokemons ->
                                callback.onSuccess(pokemons)
                            }
                        }
                        callback.onComplete()
                    }

                })
    }
}