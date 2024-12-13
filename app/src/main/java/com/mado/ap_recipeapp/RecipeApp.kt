package com.mado.ap_recipeapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController

@Composable
fun RecipeApp(navController: NavHostController = rememberNavController()) {
    val recipeViewModel: MainViewModel = viewModel()
//    val viewState by recipeViewModel.categoriesState
    val viewState = recipeViewModel.categoriesState.value


    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route) {

        composable(route = Screen.RecipeScreen.route) {
            RecipeScreen(
                navigateToDetail = { category ->
                    navController.currentBackStackEntry?.savedStateHandle?.set("category", category)
                    navController.navigate(Screen.DetailScreen.route)
                }
            )
        }


        composable(route = Screen.DetailScreen.route) {
            val category = navController.previousBackStackEntry?.savedStateHandle?.get<Category>("category")
                ?: Category("", "", "", "")
            CategoryDetailScreen(category = category)
        }
    }
}
