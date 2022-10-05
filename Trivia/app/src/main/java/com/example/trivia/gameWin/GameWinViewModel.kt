package com.example.trivia.gameWin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameWinViewModel(scored:Int,totalScore:Int):ViewModel() {
    var score = MutableLiveData<String>()
    init {
        score.value = "Score : $scored / $totalScore"
    }
}