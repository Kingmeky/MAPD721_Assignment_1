package com.example.emekeekekemapd721assignment1

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.emekeekekemapd721assignment1.data.UserStore
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    val context = LocalContext.current
    val store = UserStore(context)

    // State for input fields
    var name by remember { mutableStateOf("") }
    var userid by remember { mutableStateOf("233") }
    var email by remember { mutableStateOf("") }
    var savedData by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Input fields
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )
        OutlinedTextField(
            value = userid,
            onValueChange = { userid = it },
            label = { Text("UserID") }
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )

        // Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { saveData(store, name, userid, email, context) }) {
                Text("Save")
            }
            Button(onClick = { loadData(store) { data -> savedData = data } }) {
                Text("Load")
            }
            Button(onClick = { clearData(store) }) {
                Text("Clear")
            }
        }

        // Display saved data
        Text("Saved Data: $savedData")
        Spacer(modifier = Modifier.height(300.dp))
        Divider()
        Text(text = "301354233", fontWeight = FontWeight.Bold)
        Text(text = "Emeka Ekeke", fontWeight = FontWeight.Bold)
    }

}






