package com.example.stori.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stori.R
import com.example.stori.ui.components.ListContent
import com.example.stori.ui.components.text.Bold
import com.example.stori.ui.components.text.Regular
import com.example.stori.viewmodel.LoginViewModel

val movements = listOf(
    "Movimiento 1",
    "Movimiento 2",
    "Movimiento 3"
)

@Composable
fun HomeScreen(loginViewModel: LoginViewModel) {
    val userModel by loginViewModel.userState.collectAsState()

    Column(modifier = Modifier.padding(vertical = 15.dp, horizontal = 15.dp)) {
        Bold(
            modifier = Modifier.padding(end = 8.dp),
            color = colorResource(id = R.color.black),
            text = stringResource(id = R.string.header_title_home),
            textUnit = 18.sp
        )

        Regular(
            modifier = Modifier.padding(2.dp),
            color = colorResource(id = R.color.dark_green),
            text =  userModel.name,
            textUnit = 18.sp
        )

        Regular(
            modifier = Modifier.padding(top = 15.dp, end = 8.dp),
            color = colorResource(id = R.color.black),
            text = stringResource(id = R.string.balance),
            textUnit = 18.sp
        )

        Regular(
            modifier = Modifier.padding(2.dp),
            color = colorResource(id = R.color.dark_green),
            text = userModel.balance.toString(),
            textUnit = 18.sp
        )

        Bold(
            modifier = Modifier.padding(end = 8.dp, top = 20.dp),
            color = colorResource(id = R.color.black),
            text = stringResource(id = R.string.movements),
            textUnit = 25.sp
        )

        ListContent(movements = movements)
    }
}