package com.rakitov.androidstarterapp.model

import androidx.annotation.DrawableRes

data class Film(
    var id: Int = 0,
    var name: String = "",
    @DrawableRes
    var photo: Int = 0,
    var date_publication: String = "",
    var rating: Float = 0.0f,
    var description: String = "",
    var actors: List<Actor> = emptyList()
)

data class Actor(
    val name: String,
    @DrawableRes
    val photo: Int
)