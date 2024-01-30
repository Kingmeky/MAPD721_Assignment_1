package com.example.emekeekekemapd721assignment1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.emekeekekemapd721assignment1.data.UserStore
import com.example.emekeekekemapd721assignment1.ui.theme.EmekeEkekeMAPD721Assignment1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmekeEkekeMAPD721Assignment1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Store()
                }
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Preview(showBackground = true)
@Composable
private fun Store(){

    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val userName = remember{ mutableStateOf(TextFieldValue())}
    val name = remember { mutableStateOf(TextFieldValue()) }
    val emailAdd = remember { mutableStateOf(TextFieldValue()) }
    val store = UserStore(context)
    val userNameText = store.getAccessToken.collectAsState(initial = "")
    val nameText = store.getStudentId.collectAsState(initial = "")
    val emailAddText = store.getStudentId.collectAsState(initial = "")



}