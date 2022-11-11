package com.mk.application11.network

import com.mk.application11.database.DatabaseAnime
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

fun AnimeContainer.asDatabaseModels():Array<DatabaseAnime>{
    return data.map {
        DatabaseAnime(it.anime_id,it.anime_name,it.anime_img)
    }.toTypedArray()
}