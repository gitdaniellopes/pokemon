package br.com.daniellopes.pokemonpokeapi.kotlin.interfaces

import br.com.daniellopes.pokemonpokeapi.kotlin.model.Pokemon

interface PokemonC {

    fun onSuccess(pokemons: List<Pokemon>)

    fun onError(message: String)

    fun onComplete()
}