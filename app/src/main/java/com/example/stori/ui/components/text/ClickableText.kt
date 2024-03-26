package com.example.stori.ui.components.text

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stori.R

@Composable
fun ClickableText(
    text: String,
    clickableText: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Regular(
            modifier = Modifier.padding(end = 8.dp),
            color = colorResource(id = R.color.black),
            text = text,
            textUnit = 18.sp
        )

        Regular(
            modifier = Modifier.clickable(onClick = onClick),
            color = colorResource(id = R.color.main_color),
            text = clickableText,
            textUnit = 18.sp
        )
    }
}
