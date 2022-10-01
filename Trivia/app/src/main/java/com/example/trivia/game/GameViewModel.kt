package com.example.trivia.game

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController

class GameViewModel:ViewModel(){


    val questionAndAnswers = initQuestionAndAnswers()
    var correctAnswers = 0
    var totalQuestions = 0
    var questionsAnswered = MutableLiveData<Int>()

    val currentQuestionAndAnswer = MutableLiveData<QuestionAndAnswer>()

    val hasNextQuestion:Boolean
    get() {
        return (questionsAnswered.value!!.compareTo(totalQuestions)==-1)
    }

    init {
        totalQuestions = questionAndAnswers.size
        questionsAnswered.value = 0
        currentQuestionAndAnswer.value = questionAndAnswers[questionsAnswered.value!!]
        Log.v("vmodel","Viewmodel game created")
    }

    fun checkWin():Boolean = correctAnswers >= (totalQuestions/2)
    
    fun nextQuestion():Boolean
    {
        //count correct answer
        correctAnswers = if (questionAndAnswers[questionsAnswered.value!!].isRightAnswerGiven) correctAnswers + 1 else correctAnswers
        questionsAnswered.value = questionsAnswered.value!!.plus(1)
        //only update live data while we have next question
        if (hasNextQuestion)
            currentQuestionAndAnswer.value = questionAndAnswers[questionsAnswered.value!!]
        //return if we have next question
        return hasNextQuestion
    }
    private fun initQuestionAndAnswers(): List<QuestionAndAnswer> {
        var arr = mutableListOf<QuestionAndAnswer>()

        var question:String = "Which Linux command is used to display disk consumption of a specific directory?"
        arr.add(
            QuestionAndAnswer(
                question,
                choices = arrayOf("du", "ds", "dd", "dds"),
                answer = "du"
            )
        )

        question = " Which of the following abstract data types can be used to represent a many to many relation?"
        arr.add(
            QuestionAndAnswer(
                question,
                choices = arrayOf("Tree", "Plex", "Graph", "Both (b) and (c)"),
                answer = "Graph"
            )
        )

        question = "In networking terminology UTP means"
        arr.add(
            QuestionAndAnswer(
                question,
                choices = arrayOf(
                    "Unshielded Twisted pair ",
                    "Ubiquitious Teflon port",
                    "Uniformly Terminating port ",
                    "Unshielded T-connector port"
                ),
                answer = "Unshielded T-connector port"
            )
        )

        question = "The amount of uncertainty in a system of symbol is called?"
        arr.add(
            QuestionAndAnswer(
                question,
                choices = arrayOf("Bandwidth", "Entropy", "Loss", "Quantum"),
                answer = "Entropy"
            )
        )

        return arr
    }
}
