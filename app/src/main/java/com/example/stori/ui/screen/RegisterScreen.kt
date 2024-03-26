package com.example.stori.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.material.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stori.R
import com.example.stori.ui.components.Header
import com.example.stori.ui.components.ScrollableColumn
import com.example.stori.ui.components.button.CustomButton
import com.example.stori.ui.components.field.CustomTextField
import com.example.stori.ui.components.text.Regular
import com.example.stori.viewmodel.RegisterViewModel

@Composable
fun RegisterScreen(
    onBack: () -> Unit, onNavigateLogin: () -> Unit, viewModel: RegisterViewModel
) {
    var nameState by rememberSaveable { mutableStateOf("") }
    var surnameState by rememberSaveable { mutableStateOf("") }
    var emailState by rememberSaveable { mutableStateOf("") }
    var passwordState by rememberSaveable { mutableStateOf("") }
    val showDialog = remember { mutableStateOf(false) }
    val registerState by viewModel.signUpState.collectAsState()

    ScrollableColumn(content = {
        Column(modifier = Modifier.padding(vertical = 15.dp, horizontal = 15.dp)) {
            Image(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(120.dp),
                painter = painterResource(id = R.drawable.im_logo_horizontal),
                contentDescription = ""
            )

            CustomTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp, top = 20.dp),
                value = nameState,
                onValueChange = {
                    nameState = it
                    registerState.apply { name = nameState }
                    viewModel.setNameValid(nameState.isNotEmpty())
                },
                label = stringResource(R.string.name),
                keyboardType = KeyboardType.Text
            )

            CustomTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp, top = 20.dp),
                value = surnameState,
                onValueChange = {
                    surnameState = it
                    registerState.apply { surname = surnameState }
                    viewModel.setSurnameValid(surnameState.isNotEmpty())
                },
                label = stringResource(R.string.surname),
                keyboardType = KeyboardType.Text
            )

            CustomTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp, top = 20.dp),
                value = emailState,
                onValueChange = {
                    emailState = it
                    registerState.apply { email = emailState }
                    viewModel.setEmailValid(emailState.isNotEmpty())
                },
                label = stringResource(R.string.email),
                keyboardType = KeyboardType.Email
            )

            CustomTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp, top = 20.dp),
                value = passwordState,
                onValueChange = {
                    passwordState = it
                    registerState.apply { password = passwordState }
                    viewModel.setPasswordValid(passwordState.isNotEmpty())
                },
                label = stringResource(R.string.password),
                keyboardType = KeyboardType.Password,
                isPassword = true
            )

            viewModel.errorMessage?.let { errorMessage ->
                Regular(
                    modifier = Modifier.padding(bottom = 8.dp),
                    color = colorResource(R.color.error),
                    text = errorMessage,
                    textUnit = 15.sp
                )
            }

            CustomButton(
                modifier = Modifier
                    .requiredHeight(90.dp)
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                text = stringResource(id = R.string.register_buton),
                onClick = {
                    viewModel.register(onNavigateLogin)
                },
                loginEnable = true
            )

            if (showDialog.value) {
                AlertDialog(onDismissRequest = { showDialog.value = false }, title = {
                    Regular(
                        modifier = Modifier.padding(end = 8.dp),
                        color = colorResource(id = R.color.black),
                        text = stringResource(id = R.string.success),
                        textUnit = 18.sp
                    )
                }, confirmButton = {
                    CustomButton(modifier = Modifier.fillMaxSize(),
                        text = "Ir al login",
                        onClick = { viewModel.register(onNavigateLogin) })
                })
            }
        }
    }, header = {
        Header {
            onBack()
        }
    })
}
