package com.mk.application1.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DatabaseDao {
    @Insert
    fun insert(contact:Contact)
    @Query("Select * from contact_table order by id desc")
    fun getAllContacts():LiveData<List<Contact>>
    @Query("Delete from contact_table")
    fun clear()
}