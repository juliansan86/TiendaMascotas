package com.example.tiendademascotas.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Audiotrack
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tiendademascotas.ui.screens.*
import com.example.tiendademascotas.ui.viewmodel.PetViewModel

sealed class Screen(val route: String, val title: String, val icon: androidx.compose.ui.graphics.vector.ImageVector) {
    object Products : Screen("products", "Tienda", Icons.Default.ShoppingCart)
    object Gallery : Screen("gallery", "Galería", Icons.Default.Pets)
    object Care : Screen("care", "Cuidados", Icons.Default.Audiotrack)
}

@Composable
fun AppNavigation(petViewModel: PetViewModel = viewModel()) {
    val navController = rememberNavController()
    val items = listOf(Screen.Products, Screen.Gallery, Screen.Care)

    if (petViewModel.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else if (petViewModel.errorMessage != null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = petViewModel.errorMessage!!, color = MaterialTheme.colorScheme.error)
            Button(onClick = { petViewModel.fetchAllData() }, modifier = Modifier.padding(top = 16.dp)) {
                Text("Reintentar")
            }
        }
    } else {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    items.forEach { screen ->
                        NavigationBarItem(
                            icon = { Icon(screen.icon, contentDescription = null) },
                            label = { Text(screen.title) },
                            selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                            onClick = {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Screen.Products.route,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(Screen.Products.route) {
                    ProductListScreen(
                        products = petViewModel.products,
                        onProductClick = { product ->
                            navController.navigate("productDetail/${product.id}")
                        }
                    )
                }
                composable(
                    route = "productDetail/{productId}",
                    arguments = listOf(navArgument("productId") { type = NavType.IntType })
                ) { backStackEntry ->
                    val productId = backStackEntry.arguments?.getInt("productId")
                    val product = petViewModel.products.find { it.id == productId }
                    if (product != null) {
                        ProductDetailScreen(product = product, onBack = { navController.popBackStack() })
                    }
                }
                composable(Screen.Gallery.route) {
                    PetGalleryScreen(
                        pets = petViewModel.pets,
                        onPetClick = { pet ->
                            navController.navigate("petDetail/${pet.id}")
                        }
                    )
                }
                composable(
                    route = "petDetail/{petId}",
                    arguments = listOf(navArgument("petId") { type = NavType.IntType })
                ) { backStackEntry ->
                    val petId = backStackEntry.arguments?.getInt("petId")
                    val pet = petViewModel.pets.find { it.id == petId }
                    if (pet != null) {
                        PetDetailScreen(pet = pet, onBack = { navController.popBackStack() })
                    }
                }
                composable(Screen.Care.route) {
                    CareTipsScreen(tips = petViewModel.careTips)
                }
            }
        }
    }
}
