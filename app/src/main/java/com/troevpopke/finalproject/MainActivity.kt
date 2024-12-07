package com.troevpopke.finalproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.troevpopke.feature.home.navigation.HomeScreen
import com.troevpopke.feature.home.presentation.HomeScreen
import com.troevpopke.feature_details.navigation.DetailsScreen
import com.troevpopke.feature_details.ui.DetailsScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = HomeScreen,
            ) {
                composable<HomeScreen> {
                    HomeScreen(
                        onProductClick = { id -> navController.navigate(DetailsScreen(id)) },
                    )
                }
                composable<DetailsScreen> { entry ->
                    val route = entry.toRoute<DetailsScreen>()
                    DetailsScreen(
                        id = route.id,
                        onBackClick = { navController.popBackStack() },
                    )
                }
            }
        }
    }
}