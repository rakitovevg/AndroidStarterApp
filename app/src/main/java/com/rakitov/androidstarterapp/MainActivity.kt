package com.rakitov.androidstarterapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rakitov.androidstarterapp.model.Film

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val filmViewModel: FilmViewModel by viewModels()
        val films = filmViewModel.getFilms()
        setContent {
            FilmList(films = films)
        }
    }
}

@Composable
fun FilmList(films: List<Film>) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart) {
        LazyColumn {
            items(films) { item ->
                FilmCard(film = item)
            }
        }
    }
}

@SuppressLint("ResourceType")
@Composable
fun FilmCard(film: Film) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 4.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = film.photo),
                contentDescription = "",
                modifier = Modifier
                    .height(50.dp)
                    .width(100.dp)
            )
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = film.name,
                    modifier = Modifier
                        .padding(all = 4.dp)
                )
                Text(
                    text = film.date_publication,
                    modifier = Modifier
                        .padding(all = 4.dp)
                )
            }
        }
    }
}