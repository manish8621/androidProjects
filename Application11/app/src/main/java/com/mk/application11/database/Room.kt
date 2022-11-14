package com.mk.application11.database

import android.content.Context
import android.media.audiofx.AudioEffect.OnControlStatusChangeListener
import androidx.lifecycle.LiveData

import androidx.room.*
import com.mk.application11.network.Anime

@Dao
interface AnimeDao{
    @Query("SELECT * from anime_table")
    fun getAnimeList():LiveData<List<DatabaseAnime>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg animes:DatabaseAnime)
}

@Database(entities = [DatabaseAnime::class], version = 1, exportSchema = false)
abstract class AnimeDatabase:RoomDatabase(){
    abstract val animeDao:AnimeDao
    companion object{
        private  lateinit var INSTANCE:AnimeDatabase

        fun getDatabase(context: Context):AnimeDatabase{
            synchronized(this){
                if (!::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext, AnimeDatabase::class.java, "animes"
                    ).fallbackToDestructiveMigration().build()
                }
                return INSTANCE
            }
        }
    }
}



