package com.rakitov.androidstarterapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.rakitov.androidstarterapp.FilmViewModel
import com.rakitov.androidstarterapp.navigation.NavRoute

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "ResourceType")
@Composable
fun FilmScreen(navController: NavHostController, viewModel: FilmViewModel, filmId: String) {
    val film = viewModel.getFilms()[filmId.toInt()]

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 4.dp)
                .clickable { navController.navigate(route = NavRoute.Film.route + "/${film.id}") }
        ) {
            Row {
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
                    Text(
                        text = film.description,
                        modifier = Modifier
                            .padding(all = 4.dp)
                    )
                    Text(
                        text = film.rating.toString(),
                        modifier = Modifier
                            .padding(all = 4.dp)
                    )
                }
            }
        }
    }
}