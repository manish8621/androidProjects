package com.mk.calculator


import java.util.ArrayList
import java.util.regex.Pattern

class CalcEvaluator {

    private val BRACKET_PATTERN_WITH_PRECISION = Pattern.compile(
        "\\((([\\-]?((\\d+[\\.]\\d+)|\\d+)[\\+\\-x/%])+[\\-]?((\\d+[\\.]\\d+)|\\d+))\\)");
    private val SINGLE_NUMBER_PATTERN = Pattern.compile("\\((([\\-]?\\d+[\\.]\\d+)|[\\-]?\\d+)\\)");


    val operatorsInOrder = arrayListOf('%','/', '*');

    fun main()
    {
        getAnswer("1.2.1")
    }
    fun getAnswer(_expression: String): String {
        var expression = _expression;
        //find pattern and replace it with answer until all brackets were evaluated
        while (expression.contains("(")) {
            //find (num op num op num.....num) pattern
            var m = BRACKET_PATTERN_WITH_PRECISION.matcher(expression);
            while (m.find()) {
                // replace the inner bracket part with the answer ex:(a+b) c=a+b ,(a+b) replaced by c
                expression = m.replaceFirst(bodmasEval(m.group(1) as String).toString());
                m = BRACKET_PATTERN_WITH_PRECISION.matcher(expression);
            }

            //find (num) pattern and replace it with num
            m = SINGLE_NUMBER_PATTERN.matcher(expression);
            while (m.find()) {
                //get number and replace the (n) with n
                expression = m.replaceFirst(m.group(1) as String);
                m = SINGLE_NUMBER_PATTERN.matcher(expression);
            }
        }
        //now expression will not have brackets
        expression = bodmasEval(expression).toString();

        //if expression have multiple decimal places
        if(expression.count { it == '.' } >1)
            throw Exception("multiple decimal points in a number")


        //convert to Double
        val value = (expression).toDouble()
        if(value.toInt() == Int.MAX_VALUE) throw Exception("Expression too big")
        //if decimal value obtained return it directly else return the int version
        return if (value % 1 == 0.0) value.toInt().toString() else String.format("%.2f", value)
    }


    // Bodmas evaluation
    // split into two arrays(numbers ,operators)
    //by using operator index we can get the left right operands from numbers array and evaluate it
    private fun bodmasEval(expression: String): Double {
        val numbers = ArrayList<Double>();
        val operators = ArrayList<Char>();
        //to traverse through operators in presidence order
        var operatorIndex = -1;
        //to handle unary"-" before a number
        var unaryOperatorFound = (expression.first()=='+' || expression.first()=='-')
        //num variable stores the digits of an operand number (character by character)
        var num = "";
        for (c in expression.toCharArray()) {
            if (c.isDigit() || c == '.') {
                num += c
                unaryOperatorFound=false
            }
            else {
                if(unaryOperatorFound)
                    num += c
                else {
                    operators.add(c)
                    unaryOperatorFound = true
                    numbers.add((num).toDouble())
                    num = ""
                }

            }
        }
        // add last number
        numbers.add((num).toDouble());
        // choose highest precidential operator and do operation , remove the operator
        // and replace two numbers with answer
        for (operatorByOrder in operatorsInOrder) {
            operatorIndex = operators.indexOf(operatorByOrder)
            while (operatorIndex != -1) {
                // get answer
                val answer = eval(
                    numbers.get(operatorIndex),
                    operators[operatorIndex],
                    numbers.get(operatorIndex + 1)
                );
                // update left operand with answer in numbers array
                numbers[operatorIndex] = answer;
                // remove the right operand number from array
                numbers.removeAt(operatorIndex + 1);
                // remove the operator
                operators.removeAt(operatorIndex);
                //find the operator again
                operatorIndex = operators.indexOf(operatorByOrder)
            }
        }
        //use 0 as default index because the array we process is under modification
        operatorIndex = 0
        while (operators.isNotEmpty()) {
            // get answer
            val answer =
                eval(numbers[operatorIndex], operators[operatorIndex], numbers[operatorIndex + 1]);
            // update answer in nums
            numbers.set(operatorIndex, answer);
            // remove the other number
            numbers.removeAt(operatorIndex + 1);
            // remove the operator
            operators.removeAt(operatorIndex);
        }
        //first item of array will have the answer
        return numbers[0];
    }

    //evaluates an expression which has no parenthesis
    private fun eval(number1: Double, Operation: Char, number2: Double): Double {
        return when (Operation) {
            '+' -> number1 + number2;
            '-' -> number1 - number2;
            'x' -> number1 * number2;
            '/' -> {
                if(number2==0.0) throw Exception("Zero division error")
                number1 / number2;
            }
            '%' -> number1 % number2;
            else -> 0.0
        }
    }


    fun validateExpression(expression: String): Boolean {
        if (expression.isNotEmpty()) {
            if (expression.last().isDigit() || (expression.last() == ')'))
                return validateParenthesis(expression);
            else {
                throw Exception("Invalid operation in last position")
            }
        }

        return false;
    }

    private fun validateParenthesis(expression: String): Boolean {
        var parenthesis = 0;
        val expCharArray = expression.toCharArray();

        for (c in expCharArray) {
            if (c == '(')
                parenthesis++;
            else if (parenthesis == 0 && c == ')')
                return false;
            else if (c == ')')
                parenthesis--;
        }
        return parenthesis == 0;
    }
}
