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