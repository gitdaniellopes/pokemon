package br.com.daniellopes.pokemonpokeapi.kotlin.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.daniellopes.pokemonpokeapi.R
import br.com.daniellopes.pokemonpokeapi.kotlin.adapter.MainAdapter
import br.com.daniellopes.pokemonpokeapi.kotlin.datasource.PokemonDS
import br.com.daniellopes.pokemonpokeapi.kotlin.model.Pokemon
import br.com.daniellopes.pokemonpokeapi.kotlin.presentation.PokemonP
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainAdapter: MainAdapter

    private val recycle by lazy {
        recycle_pokemon
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initAdapter()
        configRecycle()

        val pokemonSource = PokemonDS()
        val presenter = PokemonP(this, pokemonSource)
        presenter.requestAll()

    }

    private fun initAdapter() {
        mainAdapter = MainAdapter(pokemons(), this) { pokemon ->
            val intent = Intent(this, PokemonDetailActivity::class.java)
            intent.putExtra("id", pokemon.id)
            startActivity(intent)
        }
    }

    private fun configRecycle() {
        with(recycle) {
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }


    private fun pokemons(): ArrayList<Pokemon> = arrayListOf()

    fun showPokemon(pokemons: List<Pokemon>) {
        mainAdapter.addPokemons(pokemons)
        mainAdapter.notifyDataSetChanged()
    }

    fun showFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    fun showProgressBar() {
        progress_recycle.visibility = View.VISIBLE
    }

    fun hideProgressBar() {
        progress_recycle.visibility = View.GONE
    }
}