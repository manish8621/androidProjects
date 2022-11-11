package com.mk.application2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {
    private var _contacts = MutableLiveData<List<Contact>>()
    val contacts :LiveData<List<Contact>>
    get() = _contacts

    init {
        _contacts.value = Contacts.contactsList
    }
}