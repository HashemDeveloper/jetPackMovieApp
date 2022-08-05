package com.android.jetcomposemovieapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.android.jetcomposemovieapp.model.Movie
import com.android.jetcomposemovieapp.model.getMovies
import com.android.jetcomposemovieapp.widgets.HorizontalScrollableImageView
import com.android.jetcomposemovieapp.widgets.MovieRow

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailsScreen(navController: NavController, movieId: String?) {
    val movies = getMovies().first {
        it.id == movieId
    }
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Transparent,
            elevation = 0.dp) {
            Row(horizontalArrangement = Arrangement.End) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Go Back Icon",
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    })
                Spacer(modifier = Modifier.width(100.dp))
                Text(text = "Movies")
            }
        }
    }) {
        Surface(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {
            Column(verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally) {
                MovieRow(movie = movies)
                Spacer(modifier = Modifier.padding(8.dp))
                Divider()
                Text(text = "Movie Images")
                HorizontalScrollableImageView(movies)
            }
        }
    }
}

