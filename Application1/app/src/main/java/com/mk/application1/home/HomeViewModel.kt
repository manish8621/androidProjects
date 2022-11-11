package com.mk.application1.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mk.application1.database.Contact
import com.mk.application1.database.DatabaseDao
import kotlinx.coroutines.*

class HomeViewModel(val database:DatabaseDao,application:Application): AndroidViewModel(application) {
    var name = MutableLiveData<String>("")
    var mobileNumber = MutableLiveData<String>("")

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main+viewModelJob)

    //init
    init {
        //init db
        name.value = ""
        mobileNumber.value = ""
    }
    //onSave
    fun save()
    {
        if(name.value?.isNotEmpty()?:false && mobileNumber.value?.isNotEmpty()?:false ) {
            //add to db
            val personName = name.value?:""
            val personMobNumber = mobileNumber.value?:""
            uiScope.launch {
                addToDb(personName,personMobNumber)
            }
            //clear the data from view
            name.value = ""
            mobileNumber.value = ""
        }

    }

    private suspend fun addToDb(name: String, mobNum: String) {
        val contact = Contact()
        contact.name = name
        contact.number = mobNum
        withContext(Dispatchers.IO){
            database.insert(contact)
        }
    }

    override fun onCleared() {
        super.onCleared()
        uiScope.cancel()
    }
}