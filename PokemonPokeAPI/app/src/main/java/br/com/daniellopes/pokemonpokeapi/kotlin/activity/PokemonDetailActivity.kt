package br.com.daniellopes.pokemonpokeapi.kotlin.activity

import android.app.Dialog
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.daniellopes.pokemonpokeapi.R
import br.com.daniellopes.pokemonpokeapi.kotlin.datasource.PokemonDetailDS
import br.com.daniellopes.pokemonpokeapi.kotlin.model.PokemonDetail
import br.com.daniellopes.pokemonpokeapi.kotlin.presentation.PokemonDetailP
import br.com.daniellopes.pokemonpokeapi.kotlin.util.LoadingDialog
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_pokemon.*

class PokemonDetailActivity : AppCompatActivity() {

    private var id: Int = 0

    private val loadingDialog by lazy {
        LoadingDialog(this, Dialog(this))
    }

    companion object {
        const val KEY_ID = "id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pokemon)
        setSupportActionBar(toolbar)

        configToolbar()
        getPokemonSend()

        val datasource = PokemonDetailDS()
        val presenter = PokemonDetailP(this, datasource)
        presenter.findPokemonBy(id)

    }

    fun showPokemon(pokemonDetail: PokemonDetail) {
        Glide.with(this).load(pokemonDetail.curlUrl).into(image_view_pokemon_detail)
        text_view_name_pokemon_detail.text = pokemonDetail.name
        text_view_description_pokemon_detail.text = pokemonDetail.description
        text_view_type_pokemon_detail.text = pokemonDetail.type
        text_view_number_pokemon_detail.text = pokemonDetail.numberSerial
    }

    private fun getPokemonSend() {
        intent.extras?.let {
            id = it.getInt(KEY_ID)
        }
    }

    private fun configToolbar() {
        supportActionBar?.let { toolbar ->
            toolbar.setDisplayHomeAsUpEnabled(true)
            toolbar.setHomeAsUpIndicator(R.drawable.ic_arrow_back)
            toolbar.title = null
        }
    }


    fun showFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    fun showProgressBar() {
        loadingDialog.startLoadingDialog()
    }

    fun hideProgressBar() {
        loadingDialog.dismissDialog()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}