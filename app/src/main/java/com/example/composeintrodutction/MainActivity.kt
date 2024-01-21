package com.example.composeintrodutction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeintrodutction.ui.theme.ComposeIntrodutctionTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeIntrodutctionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    //color = MaterialTheme.colorScheme.background
                ) {
                    HelloWorldView()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelloWorldView() {
    val (text, setText) = remember { mutableStateOf("Hello World") }
    val (name, setName) = remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.app_name)) },
                colors = topAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(start = 16.dp)
                    .shadow(2.dp)
            )

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Card(
                    modifier = Modifier
                        .height(200.dp)
                        .width(200.dp)
                        .shadow(8.dp),


                    ) {
                    Text(
                        text = "2",

                        modifier = Modifier
                            .padding(16.dp)

                            .align(Alignment.CenterHorizontally)
                    )

                }
            }
            OutlinedTextField(
                value = name,
                onValueChange = setName,
                label = { Text(stringResource(id = R.string.enter_your_name)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Button(
                onClick = {
                    if (name.isNotEmpty()) {
                        setText("Hello $name!")
                        setName("") // Clear the TextField after setting the text
                    } else {
                        setText(if (text == "Hello World") "Goodbye Darkness" else "Hello World")
                    }
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = stringResource(R.string.button_text))
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeIntrodutctionTheme {
        HelloWorldView()
    }
}