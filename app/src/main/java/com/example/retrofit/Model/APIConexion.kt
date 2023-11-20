package com.example.retrofit.Model

import com.example.retrofit.Model.Interfaces.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//aqui se usa en forma singleton para poder acceder a los metodos si necesidad de instanciar el objeto
object APIConexion {

    //construyo loa conexxion con la api
    private var builder = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    //Implemento los metodos que voy a utilizar en ella


    //Hago el constructor que es lo que voy a llamar para usar la api y sus metodos
    fun build(): ApiService {
        return builder.create(ApiService::class.java)
    }

}