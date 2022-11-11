package com.mk.application1.result

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.mk.application1.database.Contact
import com.mk.application1.database.DatabaseDao
import kotlinx.coroutines.*

class ResultViewModel(var database:DatabaseDao,application: Application): AndroidViewModel(application) {

    val contacts = database.getAllContacts()
    val contactsString = Transformations.map(contacts){
        contacts -> parseToString(contacts)
    }
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


    private fun parseToString(contacts: List<Contact>): String {
        val sb = StringBuilder("")
        for (contact in contacts)
        {
            sb.append("${contact.id}.name : ${ contact.name }\nnumber : ${contact.number}\n\n")
        }
        return sb.toString()
    }
}