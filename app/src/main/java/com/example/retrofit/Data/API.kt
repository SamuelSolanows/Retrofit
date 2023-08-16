package com.example.retrofit.Data

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


//aqui se usa en forma singleton para poder acceder a los metodos si necesidad de instanciar el objeto
object API {

    //construyo loa conexxion con la api
    private var builder = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    //Implemento los metodos que voy a utilizar en ella


    //Hago el constructor que es lo que voy a llamar para usar la api y sus metodos
    fun build(): Rutas {
        return builder.create(Rutas::class.java)
    }

}