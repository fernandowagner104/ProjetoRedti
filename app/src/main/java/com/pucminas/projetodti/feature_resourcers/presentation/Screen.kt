package com.pucminas.projetodti.feature_resourcers.presentation

sealed class Screen(val route: String) {
    object HomeRedti: Screen("redti")
    object Home: Screen("home")
    object Edit: Screen("edit?resourceId={resourceId}") {
        fun passId(resourceId: Int?): String {
            return "edit?resourceId=$resourceId"
        }
    }
}
