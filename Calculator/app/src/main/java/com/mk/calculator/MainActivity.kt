package com.mk.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.mk.calculator.databinding.ActivityMainBinding
import android.nfc.FormatException
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel:MainViewModel
    var evaluator = CalcEvaluator()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.mainViewModel = viewModel
        binding.lifecycleOwner = this

        //sets onClick listeners for all buttons
        setOnClickListeners();
    }


    private fun setOnClickListeners() {
        with(binding) {
            num0btn.setOnClickListener{
                handleNumberInput(it)
            }
            num1btn.setOnClickListener{
                handleNumberInput(it)
            }
            num2btn.setOnClickListener{
                handleNumberInput(it)
            }
            num3btn.setOnClickListener{
                handleNumberInput(it)
            }
            num4btn.setOnClickListener{
                handleNumberInput(it)
            }
            num5btn.setOnClickListener{
                handleNumberInput(it)
            }
            num6btn.setOnClickListener{
                handleNumberInput(it)
            }
            num7btn.setOnClickListener{
                handleNumberInput(it)
            }
            num8btn.setOnClickListener{
                handleNumberInput(it)
            }
            num9btn.setOnClickListener{
                handleNumberInput(it)
            }
            parenthesisOpenBtn.setOnClickListener{
                handleParenthesisInput(it)
            }
            parenthesisCloseBtn.setOnClickListener{
                handleParenthesisInput(it)
            }
            dotBtn.setOnClickListener{
                handleDotInput(it)
            }
            plusBtn.setOnClickListener{
                handleOperatorInput(it)
            }
            minusBtn.setOnClickListener{
                handleOperatorInput(it)
            }
            multiplyBtn.setOnClickListener{
                handleOperatorInput(it)
            }
            divBtn.setOnClickListener{
                handleOperatorInput(it)
            }
            modBtn.setOnClickListener()
            {
                handleOperatorInput(it)
            }

            equalsBtn.setOnClickListener{
                //show error msg to user like zero division errors
                try {
                    viewModel.onEqual()
                }
                catch (e:Exception)
                {
                    Toast.makeText(this@MainActivity, e.message.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun handleNumberInput(it: View) {
        viewModel.addNumToExpression((it as Button).text.toString())
    }
    private fun handleParenthesisInput(it: View?) {
        viewModel.addParenthesisToExpression((it as Button).text.toString())
    }
    private fun handleOperatorInput(it: View?) {
        viewModel.addOperatorToExpression((it as Button).text.toString())
    }
    private fun handleDotInput(it: View?) {
        viewModel.addDotToExpression()
    }
}