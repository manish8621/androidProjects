package com.mk.calculator


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel :ViewModel(){
    //to store the expression after its evaluation
    var prevExpression=MutableLiveData<String>()
    //current expression
    var expression= MutableLiveData<String>()

    private val evaluator=CalcEvaluator()


    init {
        expression.value = ""
        prevExpression.value = ""
    }

    //on equal btn pressed
    //throws many exceptions which will be used by main activity to view user the error message
    fun onEqual(){
        //if expression empty then return
            if (expression.value!!.isEmpty()) throw Exception("Empty expression")

            if (evaluator.validateExpression(expression.value.toString())) {
                copyExpressionToPrev()
                val answer = evaluator.getAnswer(expression.value.toString())
                expression.value = (answer)
            }
            else throw Exception("Unbalanced Parenthesis found")
    }


    //handle inputs
    private fun addToExpression(e:String)
    {
        expression.value += e
    }

    fun copyExpressionToPrev()
    {
        prevExpression.value = expression.value
    }

    fun addNumToExpression(e:String)
    {
        if (expression.value!!.isNotEmpty()) {
            if (expression.value!!.last() != ')')
            {
                addToExpression(e)
            }
        }
        else{
            addToExpression(e)
        }

    }

    fun addParenthesisToExpression(e: String) {
        //restrict the input to avoid extra validations

        //close parenthesis not allowed  , "." , "(" ,operators
        if(e==")") {
            if (expression.value!!.isEmpty() || expression.value!!.last()=='(' ||
                !( expression.value!!.last().isDigit()))
                if(expression.value!!.last() != ')')
                    return
        }
        //open parenthesis not allowed after number , "." , ")"
        if(e=="(") {
            if (expression.value!!.isNotEmpty() && (expression.value!!.last().isDigit() || expression.value!!.last() == '.' || expression.value!!.last() == ')'))
                return
        }
        addToExpression(e)
    }

    fun addOperatorToExpression(e: String) {
        if (expression.value!!.isEmpty()) return
        if(expression.value!!.last().isDigit() || expression.value!!.last()==')')
            addToExpression(e)
    }

    fun addDotToExpression() {
        if(expression.value!!.isEmpty()) return
        if(!expression.value!!.last().isDigit()) return
        addToExpression(".")
    }

    fun deleteExpression()
    {
        if(expression.value!!.isNotEmpty())
            expression.value = expression.value!!.subSequence(0,expression.value!!.length-1).toString()
    }
    fun clearExpression()
    {
            this.expression.value = ""
    }
    fun clearAllExpressions()
    {
            this.expression.value = ""
            this.prevExpression.value = ""
    }
}