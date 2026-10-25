package com.matamau.cuentasclaras.core.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.matamau.cuentasclaras.feature.auth.presentation.auth.AuthScreen
import com.matamau.cuentasclaras.feature.group.presentation.detail.GroupGroupDetailScreen
import com.matamau.cuentasclaras.feature.expense.presentation.create.CreateExpenseScreen
import com.matamau.cuentasclaras.feature.group.presentation.create.CreateGroupScreen
import com.matamau.cuentasclaras.feature.home.presentation.HomeScreen
import com.matamau.cuentasclaras.feature.profile.presentation.ProfileScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Auth,
        modifier = modifier.fillMaxSize(),
    ) {
        composable<Routes.Auth> {
            AuthScreen(
                onAuthSuccess = { navController.navigateToHomeAfterAuthentication() },
            )
        }

        composable<Routes.Home> {
            HomeScreen(
                userName = "Ana",
                onOpenClearingDetails = {
                    navController.navigateToDetails()
                },
                onCreateGroup = {
                    navController.navigateToCreateGroup()
                },
                onSelectTab = { destination -> navController.navigateToTab(route = destination) }
            )
        }

        composable<Routes.Detail> {
            GroupGroupDetailScreen (
                onBackClick = { navController.navigateUp() },
                onNavigate = { destination ->
                    navController.navigateToTab(route = destination)
                },
                onAddExpense = {
                    navController.navigateToExpense()
                },
                onCreateGroup = {
                    navController.navigateToCreateGroup()
                },
            )
        }

        composable<Routes.Expense> {
            CreateExpenseScreen(onBackClick = { navController.navigateUp() })
        }

        composable<Routes.Profile> {
            ProfileScreen(
                onNavigate = { navController.navigateToTab(it) },
                onCreateExpense = {
                    navController.navigateToExpense()
                },
            )
        }

        composable<Routes.CreateGroup> {
            CreateGroupScreen(
                onBackClick = { navController.navigateToHomeAfterAuthentication() },
                onAddExpense = {
                    navController.navigateToExpense()
                },
            )
        }
    }
}