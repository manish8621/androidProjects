package com.mk.calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel:ViewModel() {
    //to store the expression after its evaluation
    private var _prevExpression= MutableLiveData<String>("")
    val prevExpression :LiveData<String>
    get() = _prevExpression

    //current expression
    private var _expression= MutableLiveData<String>("")
    val expression: LiveData<String>
        get()=_expression

    private val evaluator=CalcEvaluator()

    init {
        _expression.value = ""
        _prevExpression.value = ""
    }

    //on equal btn pressed
    //throws many exceptions which will be used by main activity to view user the error message
    fun onEqual(){
        //if expression empty then return
        if (_expression.value?.isEmpty() == true) throw Exception("Empty expression")

        if (evaluator.validateExpression(_expression.value.toString())) {
            copyExpressionToPrev()
            val answer = evaluator.getAnswer(_expression.value.toString())
            _expression.value = (answer)
        }
        else throw Exception("Unbalanced Parenthesis found")
    }


    //handle inputs
    private fun addToExpression(e:String)
    {
        _expression.value += e
    }

    private fun copyExpressionToPrev()
    {
        _prevExpression.value = _expression.value
    }

    fun addNumToExpression(e:String)
    {
        if (_expression.value?.isNotEmpty()==true) {
            if (_expression.value?.last() != ')')
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
            if (_expression.value?.isEmpty()==true || _expression.value?.last()=='(' ||
                (_expression.value?.last()?.isDigit()==false))
                if(_expression.value?.last() != ')')
                    return
        }
        //open parenthesis not allowed after number , "." , ")"
        if(e=="(") {
            if (_expression.value?.isNotEmpty() == true && (_expression.value?.last()?.isDigit()==true || _expression.value?.last() == '.' || _expression.value?.last() == ')'))
                return
        }
        addToExpression(e)
    }

    fun addOperatorToExpression(e: String) {
        if (_expression.value?.isEmpty()==true) return
        if(_expression.value?.last()?.isDigit() ==true  || _expression.value?.last()==')')
            addToExpression(e)
    }

    fun addDotToExpression() {
        if(_expression.value?.isEmpty()==true) return
        if(_expression.value?.last()?.isDigit()==false) return
        addToExpression(".")
    }

    fun deleteExpression()
    {
        if(_expression.value?.isNotEmpty()==true)
            _expression.value = _expression.value?.subSequence(0,(_expression.value?.length?:0)-1).toString()
    }

    fun clearAllExpressions()
    {
        this._expression.value = ""
        this._prevExpression.value = ""
    }
}