package com.rakitov.androidstarterapp.model

import androidx.annotation.StringRes

data class Film(
    val id: Int,
    val name: String,
    @StringRes
    val photo: Int,
    val date_publication: String,
    val rating: Double,
    val description: String
)