package br.com.daniellopes.pokemonpokeapi.kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.daniellopes.pokemonpokeapi.R
import br.com.daniellopes.pokemonpokeapi.kotlin.model.Pokemon
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_main_linear.view.*

class MainAdapter(private val pokemons: MutableList<Pokemon>,
                  private val context: Context,
                  private val listener: ((Pokemon) -> Unit)?) : RecyclerView.Adapter<MainAdapter.MainHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder =
            MainHolder(LayoutInflater
                    .from(context)
                    .inflate(R.layout.item_main_linear, parent, false), listener)

    override fun getItemCount(): Int = pokemons.size

    override fun onBindViewHolder(holder: MainHolder, position: Int) =
            holder.bind(pokemons[position])

    fun addPokemons(pokemons: List<Pokemon>) {
        this.pokemons.clear()
        this.pokemons.addAll(pokemons)
    }

    inner class MainHolder(itemView: View, private val onclick: ((Pokemon) -> Unit)?) : RecyclerView.ViewHolder(itemView) {

        fun bind(pokemon: Pokemon) {
            with(itemView) {
                text_view_pokemon_name.text = pokemon.name
                Glide.with(context).load(pokemon.curlUrl).into(image_pokemon)

                image_pokemon.setOnClickListener {
                    onclick?.invoke(pokemon)
                }
            }
        }
    }
}