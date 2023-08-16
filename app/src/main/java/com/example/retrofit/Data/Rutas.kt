package com.example.retrofit.Data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Rutas {
    //@GET("pokemon?limit=151")
    @GET("pokemon?limit=150")
    fun load150Pokemons(): Call<PokemonResponse>


    @GET("pokemon")
    fun loadPokemon(@Query("limit") limit: Int): Call<PokemonResponse>
}