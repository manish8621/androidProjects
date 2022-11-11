package com.mk.application9.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL="https://anime-facts-rest-api.herokuapp.com/"
//moshi
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

interface AnimeService{
    @GET("/api/v1/")
    fun getAnimeList():Deferred<AnimeContainer>
}

object Network{
    private val retroFit = Retrofit.Builder()
        .baseUrl(BASE_URL).addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
    val animeService: AnimeService = retroFit.create(AnimeService::class.java)
}

