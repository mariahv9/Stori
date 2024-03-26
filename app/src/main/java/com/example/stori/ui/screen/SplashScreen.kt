package com.example.stori.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.stori.R
import com.example.stori.ui.components.ScrollableColumn
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onNavigate: () -> Unit) {
    LaunchedEffect(key1 = true) {
        delay(3000)
        onNavigate()
    }
    Splash()
}

@Composable
fun Splash() {
    ScrollableColumn(
        vertical = Arrangement.Center,
        content = {
            Image(
                painter = painterResource(id = R.drawable.im_logo),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
        }
    )
}
