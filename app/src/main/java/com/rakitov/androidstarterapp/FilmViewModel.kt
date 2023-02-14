package com.rakitov.androidstarterapp

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.rakitov.androidstarterapp.utils.loadJson

@SuppressLint("StaticFieldLeak")
class FilmViewModel(application: Application) : AndroidViewModel(application) {
    private val context = getApplication<Application>().applicationContext

    val films = loadJson(context)
}