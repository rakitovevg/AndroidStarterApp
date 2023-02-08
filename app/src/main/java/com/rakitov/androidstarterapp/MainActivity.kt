package com.rakitov.androidstarterapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rakitov.androidstarterapp.navigation.FilmsNavHost
import com.rakitov.androidstarterapp.ui.theme.AndroidStarterAppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mViewModel: FilmViewModel by viewModels()
        setContent {
            AndroidStarterAppTheme {

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Android Starter App")
                            },
                            backgroundColor = Color.Gray,
                            contentColor = Color.White,
                            elevation = 12.dp
                        )
                    },
                    content = {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = Color.LightGray
                        ) {
                            FilmsNavHost(mViewModel)
                        }
                    }
                )
            }
        }
    }
}