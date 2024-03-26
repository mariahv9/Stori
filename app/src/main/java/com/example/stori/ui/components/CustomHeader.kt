package com.example.stori.ui.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import com.example.stori.R
import com.example.stori.ui.components.text.Regular

@Composable
fun Header(
    title: String = "",
    color: Int = R.color.white,
    onBack: () -> Unit = {}
) {
    TopAppBar(
        title = {
            Regular(
                modifier = Modifier,
                color = colorResource(id = color),
                text = title,
                textUnit = 20.sp
            )
        },
        backgroundColor = colorResource(id = R.color.dark_green),
        contentColor = colorResource(id = color),
        navigationIcon = {
            IconButton(onClick = { onBack() }) {
                Icon(Icons.Default.ArrowBack, "Atras")
            }
        }
    )
}
