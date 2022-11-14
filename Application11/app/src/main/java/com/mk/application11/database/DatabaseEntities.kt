package com.mk.application11.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "anime_table")
data class DatabaseAnime(
    @PrimaryKey
    val animeId:Int,
    val animeName:String,
    val animeImg:String
)
