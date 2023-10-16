package com.pucminas.projetodti.feature_resourcers.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pucminas.projetodti.feature_resourcers.presentation.edit.EditScreen
import com.pucminas.projetodti.feature_resourcers.presentation.home.HomeScreen
import com.pucminas.projetodti.feature_resourcers.presentation.home.components.HomeRedtiScreen


@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.HomeRedti.route  //Home
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.HomeRedti.route) {
            HomeRedtiScreen(navController = navController)
        }
        composable(
            route = Screen.Edit.route,
            arguments = listOf(
                navArgument(
                    name = "resourceId"
                ) {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ) {
            EditScreen(navController = navController)
        }
    }
}