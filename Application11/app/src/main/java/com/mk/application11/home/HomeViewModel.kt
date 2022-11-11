package com.mk.application11.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mk.application11.database.DatabaseAnime
import com.mk.application11.database.getDatabase
import com.mk.application11.network.Anime

import com.mk.application11.network.Network
import com.mk.application11.repository.AnimeRepository
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class HomeViewModel(application: Application):AndroidViewModel(application) {
    val database = getDatabase(application)
    val repository=AnimeRepository(database)
    init {
        //refreshList()
        viewModelScope.launch {
            repository.refreshList()
        }
    }
    var animeList:LiveData<List<DatabaseAnime>> = repository.animeList

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}