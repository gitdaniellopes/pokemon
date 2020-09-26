package br.com.daniellopes.pokemonpokeapi.kotlin.datasource

import br.com.daniellopes.pokemonpokeapi.kotlin.datasource.retrofit.EndPoint
import br.com.daniellopes.pokemonpokeapi.kotlin.datasource.retrofit.PokemonAPI
import br.com.daniellopes.pokemonpokeapi.kotlin.interfaces.PokemonDetailC
import br.com.daniellopes.pokemonpokeapi.kotlin.model.PokemonDetail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonDetailDS {
    fun findBy(callback: PokemonDetailC, id: Int) {
        PokemonAPI.retrofit().create(EndPoint::class.java)
                .findPokemonBy(id).enqueue(object : Callback<PokemonDetail> {
                    override fun onFailure(call: Call<PokemonDetail>, t: Throwable) {
                        t.message?.let { error ->
                            callback.onError(error)
                        }
                    }

                    override fun onResponse(call: Call<PokemonDetail>, response: Response<PokemonDetail>) {
                        if (response.isSuccessful) {
                            response.body()?.let { pokemonDetail ->
                                callback.onSuccess(pokemonDetail)
                            }
                        }
                        callback.onComplete()
                    }

                })
    }
}