package com.example.stori.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stori.R
import com.example.stori.ui.components.text.Regular

@Composable
fun ClickableItem(item: String) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .clickable(
                onClick = {
                    // TODO
                }
            )
    ) {
        Regular(
            modifier = Modifier,
            color = colorResource(id = R.color.black),
            text = item,
            textUnit = 16.sp
        )

        Divider(color = colorResource(id = R.color.dark_green))
    }
}

@Composable
fun ListContent(movements: List<String>) {
    LazyColumn {
        items(movements) {
            ClickableItem(item = it)
        }
    }
}

