package com.rakitov.androidstarterapp

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import com.rakitov.androidstarterapp.model.Film

class FilmViewModel : ViewModel() {

    @SuppressLint("ResourceType")
    fun getFilms() = listOf(
        Film(
            1,
            "Avangers",
            R.drawable.avangers_main_800x400_jpeg,
            "01.12.2022",
            5.0,
            "the best film"
        )
    )
}