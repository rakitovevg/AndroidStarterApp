package com.rakitov.androidstarterapp.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rakitov.androidstarterapp.R
import com.rakitov.androidstarterapp.model.Film
import com.rakitov.androidstarterapp.ui.theme.Shapes

@Composable
fun FilmView(film: Film) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .padding(start = 20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(110.dp)
                .padding(bottom = 8.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            Header(film = film)
        }

        RatingView(rating = 3.5f, modifier = Modifier.padding(top = 2.dp))

        Text(
            text = film.description,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(top = 4.dp, end = 8.dp),
            color = Color.Black
        )
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Актеры",
                color = Color.Black,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 4.dp, end = 8.dp),
                fontWeight = FontWeight.Bold,
            )
            LazyRow(modifier = Modifier.padding(top = 16.dp)) {
                itemsIndexed(items = film.actors) { _, item ->
                    Column {
                        Image(
                            painter = painterResource(id = item.photo),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(end = 10.dp)
                                .height(170.dp)
                                .width(140.dp)
                                .clip(Shapes.small),
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            text = item.name,
                            color = Color.Black,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(top = 4.dp),
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Header(film: Film) {

    Column(
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier
                .height(64.dp)
                .width(204.dp)
                .padding(top = 35.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CreateChip(item = "боевики")
            Text(
                text = film.date_publication,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 14.dp, bottom = 2.dp),
                color = Color.Black
            )
        }
        Text(
            text = film.name,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(top = 14.dp)
        )
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        Image(
            painter = painterResource(id = R.drawable.icons18),
            contentDescription = "",
            modifier = Modifier
                .padding(start = 15.dp, bottom = 8.dp)
                .height(42.dp)
                .width(42.dp)
        )
    }
}