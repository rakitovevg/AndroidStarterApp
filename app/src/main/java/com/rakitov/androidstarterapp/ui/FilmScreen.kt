package com.rakitov.androidstarterapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.rakitov.androidstarterapp.FilmViewModel
import com.rakitov.androidstarterapp.ui.theme.Shapes
import com.rakitov.androidstarterapp.ui.theme.White
import com.rakitov.androidstarterapp.ui.views.FilmView


@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "ResourceType")
@Composable
fun FilmScreen(navController: NavHostController, viewModel: FilmViewModel, filmId: String) {
    val film = viewModel.getFilm(filmId.toInt())
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Image(
            painter = painterResource(id = film.photo),
            contentDescription = "",
            alignment = Alignment.TopStart,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .height(290.dp)
                .fillMaxWidth()
                .clip(Shapes.small)
        )
        Box(
            contentAlignment = Alignment.BottomStart,
            modifier = Modifier
                .fillMaxHeight()
                .padding(top = 224.dp)
                .clip(Shapes.small)
                .background(White)
        ) {
            FilmView(film = film)
        }
    }
}