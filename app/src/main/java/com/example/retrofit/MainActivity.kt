package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.retrofit.Model.APIConexion
import com.example.retrofit.Model.Models.PokemonResponse
import com.example.retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

    }

    private fun init() {
        var recuest = APIConexion.build().loadPokemon(10)
        recuest.enqueue(object : Callback<PokemonResponse> {


            //si no se conecta hará lo que implemente aki
            override fun onResponse(call: Call<PokemonResponse>, response: Response<PokemonResponse>) {
                var pokemonResponse=response.body()

                //si pokemonResponse no es nulo
                pokemonResponse?.results?.let {
                    it.forEach{
                        binding.apply {
                            txtResultado.append("${it.name} \n")
                        }
                    }
                }
            }


            //si no se conecta hará lo que implemente aki
            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                t.message?.let { Log.e("Desconectado", it) }
            }

        })
    }
}
