package com.rakitov.androidstarterapp.ui.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ChipsView(categories: List<String>) {
    LazyRow {
        itemsIndexed(items = categories) { _, item ->
            CreateChip(item = item)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CreateChip(item: String) {
    Chip(
        onClick = { /* Do something! */ },
        border = BorderStroke(
            ChipDefaults.OutlinedBorderSize,
            Color.Black
        ),
        colors = ChipDefaults.chipColors(
            backgroundColor = Color.White,
            contentColor = Color.Black
        ),
        modifier = Modifier.padding(end = 4.dp)
    ) {
        Text(
            text = item,
            modifier = Modifier.padding(2.dp)
        )
    }
}