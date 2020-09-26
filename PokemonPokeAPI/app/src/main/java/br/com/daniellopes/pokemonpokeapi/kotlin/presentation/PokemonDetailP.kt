package br.com.daniellopes.pokemonpokeapi.kotlin.presentation

import br.com.daniellopes.pokemonpokeapi.kotlin.activity.PokemonDetailActivity
import br.com.daniellopes.pokemonpokeapi.kotlin.datasource.PokemonDetailDS
import br.com.daniellopes.pokemonpokeapi.kotlin.interfaces.PokemonDetailC
import br.com.daniellopes.pokemonpokeapi.kotlin.model.PokemonDetail

class PokemonDetailP(private val view: PokemonDetailActivity, private val datasource: PokemonDetailDS) : PokemonDetailC {


    fun findPokemonBy(id: Int) {
        this.view.showProgressBar()
        this.datasource.findBy(this, id)
    }

    override fun onSuccess(pokemonDetail: PokemonDetail) {
        this.view.showPokemon(pokemonDetail)
    }

    override fun onError(message: String) {
        this.view.showFailure(message)
    }

    override fun onComplete() {
        this.view.hideProgressBar()
    }
}