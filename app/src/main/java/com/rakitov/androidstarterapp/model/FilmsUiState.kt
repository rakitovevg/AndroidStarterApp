package com.rakitov.androidstarterapp.model

data class FilmsUiState(
    var films: List<Film> = mutableListOf(),
    var categories: List<String> = mutableListOf()
)
