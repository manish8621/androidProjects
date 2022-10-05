package com.example.trivia.game

class QuestionAndAnswer(val question:String,val choices:Array<String>,val answer:String,var answerToCheck:String=""){
    val isRightAnswerGiven:Boolean
        get() = answer == answerToCheck
}