package com.mk.application10.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mk.application10.network.Anime
import com.mk.application10.network.Network
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class HomeViewModel:ViewModel() {
    var animeList = MutableLiveData<List<Anime>>()
    var animeListString = Transformations.map(animeList){
        it.toString()
    }
    var status=MutableLiveData("STATUS : Loading...")
    init {
        refreshList()
    }

    private fun refreshList() {
        viewModelScope.launch {
            try {
                val result = Network.animeService.getAnimeList().await()
                animeList.value = result.data
                status.value = "STATUS : Ok , ${result.data.size} results received."
            }
            catch (e:Exception)
            {
                status.value = "STATUS : Err , ${e.message}."
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}