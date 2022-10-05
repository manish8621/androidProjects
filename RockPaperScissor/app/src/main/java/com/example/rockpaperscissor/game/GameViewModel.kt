package com.example.rockpaperscissor.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random


class GameViewModel: ViewModel() {
    private val computerWonText="\uD83E\uDDBE\uD83E\uDD16"
    private val playerWonText="\uD83D\uDCAA\uD83C\uDFFC\uD83D\uDC68\uD83C\uDFFB"
    private val tieText = "\uD83D\uDC68\uD83C\uDFFB\uD83E\uDD1D\uD83C\uDFFB\uD83E\uDD16"
    private val moves = arrayOf("Rock","Paper","Scissor")

    private var _computerScore = MutableLiveData<Int>()
    val computerScore:LiveData<Int>
        get() = _computerScore

    private var _playerScore = MutableLiveData<Int>()
    val playerScore:LiveData<Int>
        get() = _playerScore

    private var _computerMove = MutableLiveData<String>()
    val computerMove:LiveData<String>
        get() = _computerMove


    private var _playerMove = MutableLiveData<String>()
    val playerMove:LiveData<String>
        get() = _playerMove

    private var _result = MutableLiveData<String>("_")
    val result:LiveData<String>
    get() = _result

    init {
        _computerScore.value = 0
        _playerScore.value = 0

        _computerMove.value="Ready";
        _playerMove.value="Ready";

        _result.value = "_"
    }

    private fun randomMove(): String = moves[Random.nextInt(3)]


    fun handleInput(playerCurrentMove:String)
    {
        _computerMove.value = randomMove()
        _playerMove.value =  playerCurrentMove

        if(_playerMove.value == _computerMove.value)
            _result.value = "Result : $tieText"
        else if(checkPlayerWin(_playerMove.value ?:"", computerMove.value ?:"")) {
            _result.value = "Result : $playerWonText"
            _playerScore.value = _playerScore.value?.plus(1)
        }
        else {
            _result.value = "Result : $computerWonText"
            _computerScore.value = _computerScore.value?.plus(1)
        }
    }

    private fun checkPlayerWin(player:String, computer:String): Boolean {
        //if paper lose else it will bw scissor so we win
        //if computer shows Scissor lose else it will bw scissor so we win
        //if computer shows Scissor lose else it will bw scissor so we win
        return when(player) {
            "Rock" -> computer != "Paper"
            "Paper" -> computer != "Scissor"
            else -> computer != "Rock"
        }

    }

}