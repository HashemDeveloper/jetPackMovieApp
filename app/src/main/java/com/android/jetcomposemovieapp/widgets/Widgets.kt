package com.android.jetcomposemovieapp.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.android.jetcomposemovieapp.model.Movie
import com.android.jetcomposemovieapp.model.getMovies

@Preview
@Composable
fun MovieRow(movie: Movie = getMovies()[0], onClick:(Movie) -> Unit = {}) {
    var expended by remember {
        mutableStateOf(false)
    }
    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .clickable {
            onClick(movie)
        },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)), elevation = 4.dp) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp),
                shape = RectangleShape, elevation = 4.dp) {
                if (movie.images.isNotEmpty()) {
                    Image(painter = rememberAsyncImagePainter(model =
                    ImageRequest.Builder(LocalContext.current).data(movie.images[0])
                        .crossfade(true)
                        .transformations(CircleCropTransformation()).build()),
                        contentDescription = "Movie Poster")
                } else {
                    Icon(
                        imageVector = Icons.Default.AccountBox,
                        contentDescription = "Movie Image"
                    )
                }
            }
            Column(modifier = Modifier.padding(4.dp)) {
                Text(text = movie.title, style = MaterialTheme.typography.h6)
                Text(text = "Director: ${movie.director}", style = MaterialTheme.typography.caption)
                Text(text = "Released: ${movie.year}", style = MaterialTheme.typography.caption)

                AnimatedVisibility(visible = expended) {
                    Column {
                        Text(buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.White,
                            fontSize = 13.sp)) {
                                append("Plot: ")
                            }
                            withStyle(style = SpanStyle(color = Color.White,
                            fontSize = 13.sp, fontWeight = FontWeight.Light)) {
                                append(movie.plot)
                            }
                        }, modifier = Modifier.padding(6.dp))

                        Divider(modifier = Modifier.padding(3.dp))
                        Text(text = "Director: ${movie.director}", style = MaterialTheme.typography.caption)
                        Text(text = "Actors: ${movie.actors}", style = MaterialTheme.typography.caption)
                        Text(text = "Ratings: ${movie.ratings}", style = MaterialTheme.typography.caption)

                    }
                }

                Icon(imageVector = if (expended)Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Down Arrow", modifier = Modifier
                        .size(25.dp)
                        .clickable {
                            expended = !expended
                        }, tint = Color.White
                )
            }
        }
    }
}
@Composable
fun HorizontalScrollableImageView(movies: Movie) {
    LazyRow {
        items(movies.images) { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(240.dp), elevation = 5.dp
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = ImageRequest.Builder(
                            LocalContext.current
                        ).data(image)
                            .build()
                    ), contentDescription = "Movie List Images"
                )
            }
        }
    }
}