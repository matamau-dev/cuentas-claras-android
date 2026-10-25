package com.matamau.cuentasclaras.core.navigation

import kotlinx.serialization.Serializable


sealed interface Routes {
    @Serializable
    data object Auth : Routes

    @Serializable
    data object Home : Routes

    @Serializable
    data object Detail : Routes


    @Serializable
    data object Expense : Routes

    @Serializable
    data object Profile : Routes {
    }

    @Serializable
    data object CreateGroup {
    }
}