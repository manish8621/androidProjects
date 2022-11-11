package com.mk.application1.database
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Contact::class], version = 1, exportSchema = false)
abstract class ContactDatabase :RoomDatabase(){
    abstract val dataBaseDao:DatabaseDao
    companion object{
        @Volatile
        private var INSTANCE:ContactDatabase? = null
        fun getInstance(context:Context):ContactDatabase
        {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext,ContactDatabase::class.java,"contact_table").fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}