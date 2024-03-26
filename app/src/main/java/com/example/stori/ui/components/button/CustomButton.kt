package com.example.stori.ui.components.button

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stori.R
import com.example.stori.ui.components.text.Bold

@Composable
fun CustomButton(
    modifier: Modifier,
    text: String,
    onClick: () -> Unit,
    loginEnable: Boolean = true
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = loginEnable,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = R.color.light_green),
            contentColor = colorResource(id = R.color.dark_green),
            disabledBackgroundColor = colorResource(id = R.color.dark_green_tr),
            disabledContentColor = colorResource(id = R.color.white_tr)
        ),
        shape = RoundedCornerShape(15.dp),
    ) {
        Bold(
            modifier = Modifier
                .align(Alignment.CenterVertically),
            color = colorResource(id = R.color.dark_green),
            text = text,
            textUnit = 20.sp,
            align = TextAlign.Center
        )
    }
}
