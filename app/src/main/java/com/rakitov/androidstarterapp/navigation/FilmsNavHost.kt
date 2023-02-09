package com.rakitov.androidstarterapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rakitov.androidstarterapp.FilmViewModel
import com.rakitov.androidstarterapp.screens.FilmScreen
import com.rakitov.androidstarterapp.screens.StartScreen
import com.rakitov.androidstarterapp.utils.Constants

sealed class NavRoute(val route: String) {
    object Start : NavRoute("start_screen")
    object Film : NavRoute("film_screen")
}

@Composable
fun FilmsNavHost(mViewModel: FilmViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoute.Start.route) {
        composable(NavRoute.Start.route) {
            StartScreen(
                navController = navController,
                viewModel = mViewModel
            )
        }
        composable(NavRoute.Film.route + "/{${Constants.ID}}") { navBackStackEntry ->
            navBackStackEntry.arguments?.getString(Constants.ID)
                ?.let {
                    FilmScreen(
                        navController = navController,
                        viewModel = mViewModel,
                        filmId = it
                    )
                }
        }
    }
}