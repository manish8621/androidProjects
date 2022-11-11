package com.mk.application3.result

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.mk.application3.database.Contact
import com.mk.application3.database.DatabaseDao
import kotlinx.coroutines.*

class ResultViewModel(var database:DatabaseDao,application: Application): AndroidViewModel(application) {
    var resultData = MutableLiveData<String>()
    val contacts = database.getAllContacts()

    val viewModelJob = Job()
    val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    fun clear()
    {
        uiScope.launch {
            clearAllContacts()
        }
    }

    private suspend fun clearAllContacts() {
        withContext(Dispatchers.IO){
            database.clear()
        }
    }
}