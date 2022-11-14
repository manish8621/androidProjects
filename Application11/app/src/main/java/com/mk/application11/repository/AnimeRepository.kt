package com.mk.application11.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.mk.application11.database.AnimeDatabase
import com.mk.application11.database.DatabaseAnime
import com.mk.application11.network.Network
import com.mk.application11.network.asDatabaseModels
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AnimeRepository(val database: AnimeDatabase) {

    val animeList = database.animeDao.getAnimeList()

    suspend fun refreshList(){
        withContext(Dispatchers.IO) {
            try{
                val animes = Network.animeService.getAnimeList().await()
                database.animeDao.insertAll(*(animes.asDatabaseModels()))
            }
            catch (e:Exception)
            {
                Log.e("ERROR",e.message.toString())
            }
        }
    }
}