package com.example.stori.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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
import com.example.stori.ui.components.ScrollableColumn
import com.example.stori.ui.components.button.CustomButton
import com.example.stori.ui.components.field.CustomTextField
import com.example.stori.ui.components.text.ClickableText
import com.example.stori.ui.components.text.Regular
import com.example.stori.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    onNavigateRegister: () -> Unit,
    onNavigateHome: () -> Unit,
    viewModel: LoginViewModel
) {
    var emailState by rememberSaveable { mutableStateOf("") }
    var passwordState by rememberSaveable { mutableStateOf("") }

    ScrollableColumn(content = {
        Column(modifier = Modifier.padding(vertical = 15.dp, horizontal = 15.dp)) {
            Image(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(180.dp),
                painter = painterResource(id = R.drawable.im_logo_horizontal),
                contentDescription = ""
            )

            CustomTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp, top = 20.dp),
                value = emailState,
                onValueChange = {
                    emailState = it
                    viewModel.setEmailValid(emailState.isNotEmpty())
                },
                label = stringResource(R.string.email),
                keyboardType = KeyboardType.Email
            )


            if (!viewModel.isUserName) {
                Regular(
                    modifier = Modifier.padding(top = 2.dp),
                    color = colorResource(R.color.light_green),
                    text = stringResource(
                        id = R.string.required,
                        stringResource(id = R.string.email)
                    ),
                    textUnit = 15.sp
                )
            }

            CustomTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp, top = 20.dp),
                value = passwordState,
                onValueChange = {
                    passwordState = it
                    viewModel.setPasswordValid(passwordState.isNotEmpty() && passwordState.length > 8)
                },
                label = stringResource(R.string.password),
                keyboardType = KeyboardType.Password,
                isPassword = true
            )

            if (!viewModel.isPassword) {
                Regular(
                    modifier = Modifier.padding(top = 2.dp),
                    color = colorResource(R.color.light_green),
                    text = stringResource(
                        id = R.string.required,
                        stringResource(id = R.string.password)
                    ),
                    textUnit = 15.sp
                )
            }

            CustomButton(
                modifier = Modifier
                    .requiredHeight(90.dp)
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                text = stringResource(id = R.string.login_button),
                onClick = {
                    viewModel.signIn(onNavigateHome, emailState, passwordState)
                }, loginEnable = viewModel.isUserName && viewModel.isPassword
            )

            viewModel.errorMessage.value?.let { errorMessage ->
                Regular(
                    modifier = Modifier.padding(top = 8.dp),
                    color = colorResource(R.color.error),
                    text = errorMessage,
                    textUnit = 15.sp
                )
            }

            ClickableText(
                text = stringResource(id = R.string.register_text),
                clickableText = stringResource(id = R.string.register)
            ) {
                onNavigateRegister()
            }
        }
    })
}
