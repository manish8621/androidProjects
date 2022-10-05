package com.example.trivia.gameWin
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras

class GameWinViewModelFactory(private val scored:Int, private val totalScore:Int):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameWinViewModel::class.java)) {
            return GameWinViewModel(scored, totalScore) as T
        }
        throw IllegalArgumentException("unknown viewModel class")
    }
}