package com.android.jetcomposemovieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.android.jetcomposemovieapp.screens.DetailsScreen
import com.android.jetcomposemovieapp.screens.HomeScreen

/**
 * structure -> Navigation Component
 *                      Navigation Controller
 *                              Navigation Host
 *                                      Navigation Graph
 */
@Composable
fun MovieNavigation() {
    // Navigation Controller instructs to navigate from one route to another
    val navController = rememberNavController()
    // Navigation Host: hosts the graph items and swaps out the destination(composable) when user navigates to different route
    NavHost(navController = navController, startDestination = MovieScreens.HOME_SCREEN.name) {
        //Navigation Graph: this is where we will build the navigation graph
        // Navigation graph holds the information about destination/screens/composable
        composable(route = MovieScreens.HOME_SCREEN.name) {
            // here we pass where this should lead us
            HomeScreen(navController = navController)
        }
        composable(
            route = MovieScreens.DETAILS_SCREEN.name + "/{movie}",
            arguments = listOf(
                navArgument("movie") { type = NavType.StringType })
        ) {backStackEntry ->
            DetailsScreen(navController = navController, backStackEntry.arguments?.getString("movie"))
        }
    }
}