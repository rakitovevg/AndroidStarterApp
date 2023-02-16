package com.rakitov.androidstarterapp.model

import androidx.annotation.DrawableRes

data class Film(
    val id: Int,
    val name: String,
    @DrawableRes
    val photo: Int,
    val date_publication: String,
    val rating: Float,
    val description: String,
    val actors: List<Actor>
)

data class Actor(
    val name: String,
    @DrawableRes
    val photo: Int
)