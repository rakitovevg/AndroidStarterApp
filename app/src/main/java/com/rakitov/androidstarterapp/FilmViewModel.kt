package com.rakitov.androidstarterapp

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.rakitov.androidstarterapp.model.Film
import com.rakitov.androidstarterapp.model.FilmsUiState
import com.rakitov.androidstarterapp.utils.loadJson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@SuppressLint("StaticFieldLeak")
class FilmViewModel(application: Application) : AndroidViewModel(application) {

    private val _uiState = MutableStateFlow(FilmsUiState())
    private val context = getApplication<Application>().applicationContext

    val uiState: StateFlow<FilmsUiState> = _uiState.asStateFlow()

    var searchField by mutableStateOf("")
        private set

    var film by mutableStateOf(Film())
        private set

    init {
        _uiState.value = FilmsUiState(
            films = loadJson(context),
            categories = context.resources.getStringArray(R.array.categories).toList()
        )
    }

    fun updateSearchField(userInput: String) {
        searchField = userInput
    }

    fun getFilm(id: Int): Film {
        film = loadJson(context)[id]
        return film
    }
}