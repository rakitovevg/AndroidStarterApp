package com.rakitov.androidstarterapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.rakitov.androidstarterapp.FilmViewModel
import com.rakitov.androidstarterapp.R
import com.rakitov.androidstarterapp.model.Film
import com.rakitov.androidstarterapp.navigation.NavRoute
import com.rakitov.androidstarterapp.ui.theme.Shapes
import com.rakitov.androidstarterapp.views.ChipsView
import com.rakitov.androidstarterapp.views.RatingView
import com.rakitov.androidstarterapp.views.SearchView
import java.util.*

@SuppressLint("ResourceType", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StartScreen(navController: NavHostController, viewModel: FilmViewModel) {
    val categoriesArray = stringArrayResource(id = R.array.categories)

    val films = viewModel.films
    val state = remember {
        mutableStateOf(TextFieldValue(""))
    }
    val categories = remember {
        mutableStateListOf(categoriesArray)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = Color.White
    ) {
        Column(
            modifier = Modifier.padding(
                start = 20.dp
            )
        ) {
            SearchView(state = state)
            Text(
                text = "Популярное сейчас:",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp, end = 21.dp),
                color = Color.Black
            )
            ChipsView(categories)
            FilmsRenderer(films = films, navController = navController)
        }
    }
}

@Composable
fun FilmsRenderer(films: List<Film>, navController: NavHostController) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(films) { item ->
            FilmCard(film = item, navController)
        }
    }
}

@SuppressLint("ResourceType")
@Composable
fun FilmCard(film: Film, navController: NavHostController) {
    Card(
        modifier = Modifier
            .padding(top = 16.dp, bottom = 9.dp, end = 21.dp)
            .fillMaxSize()
            .clickable { navController.navigate(route = NavRoute.Film.route + "/${film.id}") },
        backgroundColor = Color.White,
        elevation = 0.dp
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.wrath),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(Shapes.small)
                    .height(216.dp)
            )
            Text(
                text = film.name,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = film.description,
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 10.dp)
                    .height(90.dp),
                fontSize = 12.sp,
                color = Color.Black,
                maxLines = 6,
                overflow = TextOverflow.Ellipsis
            )
            Row {
                RatingView(
                    rating = film.rating, modifier = Modifier
                        .width(100.dp)
                        .align(Alignment.Bottom)
                )
                Image(
                    painter = painterResource(id = R.drawable.icons18),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(start = 15.dp)
                        .height(30.dp)
                        .width(30.dp),

                    )
            }
        }
    }
}