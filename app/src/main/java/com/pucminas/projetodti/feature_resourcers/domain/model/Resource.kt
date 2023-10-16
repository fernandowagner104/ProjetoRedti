package com.pucminas.projetodti.feature_resourcers.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Resource(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val resourceName: String,
    @ColumnInfo(name = "brand") val brand: String,
    val qnt: Int,
    val featureResource: String,
    val obs: String
)
