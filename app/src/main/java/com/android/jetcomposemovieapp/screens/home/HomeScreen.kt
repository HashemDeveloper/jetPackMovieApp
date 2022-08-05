package com.android.jetcomposemovieapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.android.jetcomposemovieapp.model.Movie
import com.android.jetcomposemovieapp.model.getMovies
import com.android.jetcomposemovieapp.navigation.MovieScreens
import com.android.jetcomposemovieapp.widgets.MovieRow
import com.google.gson.Gson
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Transparent,
            elevation = 0.dp) {
            Text(text = "Movies")
        }
    }) {_ ->
        MainContent(navController)
    }
}
@Composable
private fun MainContent(navController: NavController, listOfMovies: MutableList<Movie> = getMovies()) {
    LazyColumn(content = {
        items(items = listOfMovies) {movie ->
            MovieRow(movie = movie) {
                navController.navigate(route = MovieScreens.DETAILS_SCREEN.name + "/${it.id}")
            }
        }
    })
}