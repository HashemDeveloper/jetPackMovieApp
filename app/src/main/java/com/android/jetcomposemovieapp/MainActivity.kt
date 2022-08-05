package com.android.jetcomposemovieapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.jetcomposemovieapp.navigation.MovieNavigation
import com.android.jetcomposemovieapp.ui.theme.JetComposeMovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppEntryPoint {
                MovieNavigation()
            }
        }
    }

    @Composable
    private fun AppEntryPoint(content: @Composable () -> Unit) {
        JetComposeMovieAppTheme {
           content()
        }
    }
    @Composable
    private fun MainContent() { 
        Surface(color = MaterialTheme.colors.background) {
            Text(text = "HELLO AGAIN AND AGAIN!")
        }
    }
//    @Composable
//    private fun TestLazyColumn(listOfMovies: List<String> = listOf(
//        "Brave Heart","Scarface","GodFather","Forest Gum"
//    )) {
//       Column(modifier = Modifier.padding(5.dp)) {
//           LazyColumn(content = {
//               items(items = listOfMovies) {
//                   Text(text = it)
//               }
//           }, verticalArrangement = Arrangement.SpaceBetween,
//           horizontalAlignment = Alignment.Start)
//           Spacer(modifier = Modifier.height(20.dp))
//           LazyRow(content = {
//               items(items = listOfMovies) {
//                   MovieRow(movie = it){}
//               }
//           })
//       }
//    }

    @Preview("Default", showBackground = true, showSystemUi = true)
    @Composable
    private fun DefaultPreview() {
        AppEntryPoint {
            MovieNavigation()
        }
    }
}