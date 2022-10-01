package com.example.trivia.game

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import com.example.trivia.databinding.FragmentGameBinding

class GameFragment:Fragment()
{
    private lateinit var binding: FragmentGameBinding
    private lateinit var viewModel:GameViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //view model init
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)
        binding.gameViewModel = viewModel
        binding.lifecycleOwner = this
        setOnClickListeners()
//        setupObservers()
    }


    private fun setOnClickListeners() {

        binding.apply {

            //for radio buttons
            for (childIndex in 0..choicesGroup.childCount) {
                val choice: RadioButton? = (choicesGroup.getChildAt(childIndex) as? RadioButton)
                choice?.setOnClickListener {
                    viewModel.currentQuestionAndAnswer.value!!.answerToCheck = choice.text as String
                }
            }

            //for submit button
            submitBtn.setOnClickListener {
                if (isOptionSelected()) {
                    //new question will be rendered
                    //check for win
                    binding.choicesGroup.clearCheck()
                    if(! viewModel.nextQuestion())
                    {
                        if(viewModel.checkWin())
                            findNavController().navigate(
                                GameFragmentDirections.actionGameFragmentToGameWinFragment(
                                    viewModel.totalQuestions,
                                    viewModel.correctAnswers
                                )
                            )
                        else
                            findNavController().navigate(
                                GameFragmentDirections.actionGameFragmentToGameOverFragment(
                                    viewModel.totalQuestions,
                                    viewModel.correctAnswers
                                )
                            )
                    }
                } else Toast.makeText(context, "Please select any answer", Toast.LENGTH_SHORT).show()
            }

        }

    }
    private fun isOptionSelected(): Boolean = binding.choicesGroup.checkedRadioButtonId != -1

}