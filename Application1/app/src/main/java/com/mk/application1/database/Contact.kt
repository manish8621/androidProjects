package com.mk.application1.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact_table")
class Contact {
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0L
    @ColumnInfo(name = "name")
    var name:String=""
    @ColumnInfo(name = "mobilenumber")
    var number:String = ""
}