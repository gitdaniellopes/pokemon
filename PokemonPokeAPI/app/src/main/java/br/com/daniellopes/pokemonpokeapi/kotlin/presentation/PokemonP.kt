package br.com.daniellopes.pokemonpokeapi.kotlin.presentation

import br.com.daniellopes.pokemonpokeapi.kotlin.activity.MainActivity
import br.com.daniellopes.pokemonpokeapi.kotlin.datasource.PokemonDS
import br.com.daniellopes.pokemonpokeapi.kotlin.interfaces.PokemonC
import br.com.daniellopes.pokemonpokeapi.kotlin.model.Pokemon

class PokemonP(private val view: MainActivity, val datasource: PokemonDS) : PokemonC {

    fun requestAll() {
        this.view.showProgressBar()
        this.datasource.findAll(this)
    }

    override fun onSuccess(pokemons: List<Pokemon>) {
        this.view.showPokemon(pokemons)
    }

    override fun onError(message: String) {
        this.view.showFailure(message)
    }

    override fun onComplete() {
        this.view.hideProgressBar()
    }
}