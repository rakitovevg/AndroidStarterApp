package com.rakitov.androidstarterapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.rakitov.androidstarterapp.FilmViewModel
import com.rakitov.androidstarterapp.model.Film
import com.rakitov.androidstarterapp.navigation.NavRoute

@SuppressLint("ResourceType", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StartScreen(navController: NavHostController, viewModel: FilmViewModel) {

    val films = viewModel.getFilms()

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            items(films) { item ->
                FilmCard(film = item, navController)
            }
        }
    }
}

@SuppressLint("ResourceType")
@Composable
fun FilmCard(film: Film, navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 4.dp)
            .clickable { navController.navigate(route = NavRoute.Film.route + "/${film.id}") }
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