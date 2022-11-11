package com.mk.application9.network

import androidx.lifecycle.LiveData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Anime(
    val anime_id:Int,
    val anime_name:String,
    val anime_img:String
)


@JsonClass(generateAdapter = true) //?
data class AnimeContainer(
    val success:Boolean,
    val data:List<Anime>
)