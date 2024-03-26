package com.example.stori.ui.components.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

@Composable
fun Medium(
    modifier: Modifier,
    color: Color,
    text: String,
    textUnit: TextUnit
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        fontWeight = FontWeight.Medium,
        fontSize = textUnit
    )
}
