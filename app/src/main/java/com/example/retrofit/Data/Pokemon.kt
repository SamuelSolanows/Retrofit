package com.example.retrofit.Data

data class PokemonResponse(
    var count: Int,
    var next: String,
    var previous: String,
    var results: List<Pokemon>
)

data class Pokemon(var name: String, var url: String)