package com.example.mpmp4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mpmp4.ui.theme.MPMP4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MPMP4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center // Центрування по вертикалі
                    ) {
                        Greeting(name = "Світ")
                        Spacer(modifier = Modifier.height(16.dp)) // Відступ між компонентами
                        Quote("Зараз чи взагалі")
                        Spacer(modifier = Modifier.height(16.dp)) // Відступ між компонентами
                        GreetingWithButton()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Привіт, $name!",
        modifier = modifier.wrapContentSize(),
        style = MaterialTheme.typography.bodyLarge
    )
}

@Composable
fun Quote(quote: String) {
    Text(
        text = quote,
        modifier = Modifier.wrapContentSize(),
        style = MaterialTheme.typography.bodyLarge
    )
}

@Composable
fun GreetingWithButton() {
    var text by remember { mutableStateOf("Привіт, Світ!") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 16.dp) // Відступ між текстом і кнопкою
        )
        Button(
            onClick = { text = "Текст змінено!" }
        ) {
            Text(text = "Змінити текст")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MPMP4Theme {
        Greeting("Android")
    }
}