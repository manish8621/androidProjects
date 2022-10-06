package com.gamesmk.pickcoins.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ResultViewModelFactory(val winner:String,val player1Score:String,val player2Score:String):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ResultViewModel::class.java))
        return ResultViewModel(this.winner,player1Score,player2Score) as T
        throw IllegalArgumentException("illegal arg")
    }
}