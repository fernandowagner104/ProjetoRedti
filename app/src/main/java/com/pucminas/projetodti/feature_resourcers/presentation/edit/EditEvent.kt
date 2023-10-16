package com.pucminas.projetodti.feature_resourcers.presentation.edit

sealed class EditEvent {
    data class EnteredNameResource(val value: String): EditEvent()
    data class EnteredBrand(val value: String): EditEvent()
    data class EnteredQnt(val value: String): EditEvent()
    data class EnteredFeatureResource(val value: String): EditEvent() //mine
    data class EnteredObs(val value: String): EditEvent() //mine
    object InsertResource: EditEvent()
}