
package com.example.sarah_malik_hw2q3

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
import androidx.compose.material3.Button
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
import androidx.compose.ui.unit.sp
import com.example.sarah_malik_hw2q3.ui.theme.Sarah_Malik_hw2q3Theme

import android.annotation.SuppressLint
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Sarah_Malik_hw2q3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "World",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@SuppressLint("SuspiciousIndentation")
fun randomQuote(): String {
    val stringArray = arrayOf( // got the quotes from chatGPT
        "Honey never spoils.",
        "A group of flamingos is called a 'flamboyance'.",
        "Bananas are berries, but strawberries aren’t.",
        "Octopuses have three hearts.",
        "A day on Venus is longer than a year on Venus.",
        "Wombat poop is cube-shaped.",
        "The Eiffel Tower can be 15 cm taller during the summer.",
        "Some cats are allergic to humans.",
        "An apple floats in water because it’s 25% air.",
        "A cloud can weigh more than a million pounds.",
        "The heart of a shrimp is located in its head.",
        "Koalas sleep up to 22 hours a day.",
        "Sloths can take up to a month to digest their food.",
        "Scotland's national animal is the unicorn.",
        "Dolphins have names for each other.",
        "A single strand of spaghetti is called a 'spaghetto'.",
        "The shortest war in history lasted 38 to 45 minutes.",
        "A day on Jupiter lasts about 10 hours.",
        "The human nose can remember 50,000 different scents.",
        "Butterflies taste with their feet."

    )
    val quote = Random.nextInt(stringArray.size)
    return stringArray[quote] // returns random quote
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var quote by remember {
        mutableStateOf(value = randomQuote()) // state of the view
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = quote,
            fontSize = 20.sp, // hello world text placement
            modifier = Modifier.height(90.dp) // button placement
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            quote = randomQuote()
        }) {
            Text(
                text = "Next Fact", // text of the button
                fontSize = 20.sp
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Sarah_Malik_hw2q3Theme {
        Greeting("Android")
    }
}
