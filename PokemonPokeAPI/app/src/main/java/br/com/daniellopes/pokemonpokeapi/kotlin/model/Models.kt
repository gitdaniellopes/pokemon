package br.com.daniellopes.pokemonpokeapi.kotlin.model

data class Pokemon(val id: Int = 0,
                   val name: String = "",
                   val curlUrl: String = "")

data class PokemonDetail(val id: Int = 0,
                         val name: String = "",
                         val curlUrl: String = "",
                         val description: String = "",
                         val type: String = "",
                         val numberSerial: String = "")