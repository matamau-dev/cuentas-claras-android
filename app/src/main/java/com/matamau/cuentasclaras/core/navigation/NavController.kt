package com.matamau.cuentasclaras.core.navigation

import androidx.navigation.NavController


fun NavController.navigateToHomeAfterAuthentication() {
    navigate(Routes.Home) {
        popUpTo(Routes.Auth) { inclusive = true }
    }
}

fun NavController.navigateToDetails() {
    navigate(Routes.Detail)
}

fun NavController.navigateToExpense() {
    navigate(Routes.Expense)
}

fun NavController.navigateToTab(route: Routes) {
    navigate(route) {
        popUpTo(Routes.Home)
        launchSingleTop = true
    }
}

fun NavController.navigateToCreateGroup() {
    navigate(Routes.CreateGroup)
}

fun NavController.navigateToExpenseDetail(){
    navigate(Routes.ExpenseDetail)
}