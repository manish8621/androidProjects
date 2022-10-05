package com.mk.calculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.mk.calculator.databinding.FragmentCalculatorBinding


class CalculatorFragment : Fragment() {
    lateinit var binding:FragmentCalculatorBinding
    lateinit var viewModel:CalculatorViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalculatorBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(CalculatorViewModel::class.java)
        binding.viewModel = viewModel
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
                    viewModel?.onEqual()
                }
                catch (e:Exception)
                {
                    if(e.message?.equals("Expression too big")==true) viewModel?.clearAllExpressions()
                    Toast.makeText(activity, e.message.toString(), Toast.LENGTH_SHORT).show()
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