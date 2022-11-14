package com.mk.application11.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.mk.application11.database.DatabaseAnime
import com.mk.application11.database.AnimeDatabase.Companion.getDatabase
import com.mk.application11.repository.AnimeRepository
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class HomeViewModel(application: Application):AndroidViewModel(application) {
    val database = getDatabase(application)
    private val repository=AnimeRepository(database)

    var animeList:LiveData<List<DatabaseAnime>> = repository.animeList

    init {
        //refreshList()
        viewModelScope.launch {
            repository.refreshList()
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}