package com.gamesmk.pickcoins.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
    //set default value of total coins
    val coins=50

    private var _totalCoins=MutableLiveData(coins)
    val totalCoins :LiveData<Int>
        get() = _totalCoins

    private var _gameFinished=MutableLiveData(false)
    val gameFinished :LiveData<Boolean>
        get() = _gameFinished

    private var _player1Score=MutableLiveData(0)
    val player1Score :LiveData<Int>
    get() = _player1Score

    private var _player2Score=MutableLiveData(0)
    val player2Score :LiveData<Int>
        get() = _player2Score

    val coinText = "\uD83E\uDE99"

    fun updatePlayer1Score() {
        _player1Score.value = _player1Score.value?.plus(1)
        _totalCoins.value = _totalCoins.value?.minus(1)
        if(_totalCoins.value==0)
        {
            _gameFinished.value = true
        }
    }
    fun updatePlayer2Score()
    {
        _player2Score.value = _player2Score.value?.plus(1)
        _totalCoins.value = _totalCoins.value?.minus(1)
        if(_totalCoins.value==0)
        {
            _gameFinished.value = true
        }
    }

//    fun checkWin(): Boolean {
//        return (totalCoins.value == 0)
//    }

    fun resetAll() {
        _totalCoins.value = coins
        _player1Score.value = 0
        _player2Score.value = 0
        _gameFinished.value = false
    }

    fun getWinner(): String {
        val p1 = _player1Score.value?:0
        val p2 = _player2Score.value?:0
        if(p1==p2)
            return "Match Tie ${player1Score.value} ${player2Score.value}"
        if(p1>p2)
            return "Player1 wins"
        return "Player2 wins"
    }
}