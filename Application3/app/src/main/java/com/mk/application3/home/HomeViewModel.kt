package com.mk.application3.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mk.application3.database.Contact
import com.mk.application3.database.DatabaseDao
import kotlinx.coroutines.*
import java.util.*

class HomeViewModel(val database:DatabaseDao,application:Application): AndroidViewModel(application) {
    var name = MutableLiveData<String>("")
    var mobileNumber = MutableLiveData<String>("")
    var gender = MutableLiveData<String>("")
    var relation = MutableLiveData<String>("")

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main+viewModelJob)

    //init
    init {
        name.value = ""
        mobileNumber.value = ""
    }

    //onSave
    fun save()
    {
        if(name.value?.isNotEmpty() == true && mobileNumber.value?.isNotEmpty() == true && gender.value?.isNotEmpty() == true && relation.value?.isNotEmpty() == true) {
            //add to db
            val personName = name.value?:""
            val personMobNumber = mobileNumber.value?:""

            var personGender = gender.value?: "".lowercase(Locale.ROOT)
            if(personGender!="male"&&personGender!="female")
                personGender = "male"

            val personRelation = relation.value?:""
            uiScope.launch {
                addToDb(personName,personMobNumber,personGender,personRelation)
            }
            //clear the data from view
            name.value = ""
            mobileNumber.value = ""
        }

    }

    private suspend fun addToDb(name: String, mobNum: String,gender:String,relation:String) {
        val contact = Contact()
        contact.name = name
        contact.number = mobNum
        contact.gender = gender
        contact.relation = relation
        withContext(Dispatchers.IO){
            database.insert(contact)
        }
    }

    override fun onCleared() {
        super.onCleared()
        uiScope.cancel()
    }
}