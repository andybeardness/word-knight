package com.beardness.wordknight.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.beardness.wordknight.presentaion.screen.about.AboutScreen
import com.beardness.wordknight.presentaion.screen.search.SearchScreen

@Composable
fun Navigation(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = "search",
    ) {
        composable(route = "search") {
            SearchScreen(
                viewModel = hiltViewModel(),
                navigateToAboutScreen = { navController.navigate(route = "about") }
            )
        }

        composable(route = "about") {
            AboutScreen(
                viewModel = hiltViewModel(),
            )
        }
    }
}