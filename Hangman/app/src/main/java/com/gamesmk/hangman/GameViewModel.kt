package com.gamesmk.hangman

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class GameViewModel:ViewModel() {
    var wordList = initWordList()
    var puzzle = MutableLiveData("")
    var currentWord = MutableLiveData("")
    var hangmanState = MutableLiveData(1)
    init {
        nextWord()
    }

    fun solvePuzzle(text: String):Boolean{
        if(currentWord.value?.contains(text)==true)
        {
            var temp = ""
            var cWord = currentWord.value?:""



            for ((index,c) in cWord.withIndex())
            {
                if(text[0] == c)
                {
                    temp += c
                }
                else
                {
                    temp+=puzzle.value?.get(index)
                }
            }
            puzzle.value = temp
            return true
        }
        else{
            hangmanState.value = hangmanState.value?.plus(1)
            return false
        }
    }

    fun nextWord()
    {
        if(wordList.isNotEmpty())
        {
            wordList.shuffle()
            //set word
            currentWord.value = wordList[0]
            //to puzzle
            var temp = ""
            for ((index,c) in wordList[0].withIndex())
            {
                temp+=if((index==(wordList[0].length)/2)||(index==wordList[0].length-1)) wordList[0].get(index) else "_"
            }
            //set puzzle
            puzzle.value = temp

            //remove the word
            wordList.removeAt(0)
        }


    }

    private fun initWordList(): ArrayList<String> {
        var arr = arrayListOf<String>("about", "above", "abuse", "accept", "accident",
            "accuse", "across", "activist", "actor", "administration", "admit", "adult",
            "advertise", "advise", "affect", "afraid", "after", "again", "against", "agency"
            )
        return arr
    }

    fun checkWin():Boolean {
        if(!((puzzle.value?:"").contains("_")))
        {
            hangmanState.value = -1
            return true
        }
        return false
    }

    fun checkGameOver(): Boolean {
        return hangmanState.value==6
    }
    fun resetHangmanState()
    {
        hangmanState.value = 1
    }

    fun revealWord() {
        puzzle.value = currentWord.value
    }
}