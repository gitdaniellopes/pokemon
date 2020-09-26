package br.com.daniellopes.pokemonpokeapi.kotlin.interfaces

import br.com.daniellopes.pokemonpokeapi.kotlin.model.PokemonDetail

interface PokemonDetailC {

    fun onSuccess(pokemonDetail: PokemonDetail)

    fun onError(message: String)

    fun onComplete()
}