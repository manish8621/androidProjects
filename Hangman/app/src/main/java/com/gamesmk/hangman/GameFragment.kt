package com.gamesmk.hangman

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.gamesmk.hangman.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    lateinit var binding:FragmentGameBinding
    lateinit var viewModel:GameViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[GameViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setButtonsClickable(true)
        setOnclickListeners()
        setObservers()
    }

    private fun setObservers() {
        viewModel.hangmanState.observe(viewLifecycleOwner,Observer{
            setHangmanImage(it)
        })
    }

    private fun setHangmanImage(state:Int) {
        binding.hangmanStateIv.setImageResource(when(state){
            1-> R.drawable.state1
            2-> R.drawable.state2
            3-> R.drawable.state3
            4-> R.drawable.state4
            5-> R.drawable.state5
            6-> R.drawable.state6
            else -> R.drawable.statewin
        })
    }

    private fun setOnclickListeners() {
        binding.apply {
            aBtn.setOnClickListener{
                handleTextInput(it)
                it.isClickable = false
            }
            bBtn.setOnClickListener{
                handleTextInput(it)
                it.isClickable = false
            }
            cBtn.setOnClickListener{
                handleTextInput(it)
                it.isClickable = false
            }
            dBtn.setOnClickListener{
                handleTextInput(it)
                it.isClickable = false
            }
            eBtn.setOnClickListener{
                handleTextInput(it)
                it.isClickable = false
            }
            fBtn.setOnClickListener{
                handleTextInput(it)
                it.isClickable = false
            }
            gBtn.setOnClickListener{
                handleTextInput(it)
                it.isClickable = false
            }
            hBtn.setOnClickListener{
                handleTextInput(it)
                it.isClickable = false
            }
            iBtn.setOnClickListener{
                handleTextInput(it)
                it.isClickable = false
            }
            jBtn.setOnClickListener{
                handleTextInput(it)
                it.isClickable = false
            }
            kBtn.setOnClickListener{
                handleTextInput(it)
                it.isClickable = false
            }
            lBtn.setOnClickListener{
                handleTextInput(it)
                it.isClickable = false
            }
            mBtn.setOnClickListener{
                handleTextInput(it)
                it.isClickable = false
            }
            nBtn.setOnClickListener{
                handleTextInput(it)
                it.isClickable = false
            }
            oBtn.setOnClickListener{
                handleTextInput(it)
                it.isClickable = false
            }
            pBtn.setOnClickListener{
                handleTextInput(it)
                it.isClickable = false
            }
            qBtn.setOnClickListener{
                handleTextInput(it)
                it.isClickable = false
            }
            rBtn.setOnClickListener{
                handleTextInput(it)
                it.isClickable = false
            }
            sBtn.setOnClickListener{
                handleTextInput(it)
                it.isClickable = false
            }
            tBtn.setOnClickListener{
                handleTextInput(it)
                it.isClickable = false
            }
            uBtn.setOnClickListener{
                handleTextInput(it)
                it.isClickable = false
            }
            vBtn.setOnClickListener{
                handleTextInput(it)
                it.isClickable = false
            }
            wBtn.setOnClickListener{
                handleTextInput(it)
                it.isClickable = false
            }
            xBtn.setOnClickListener{
                handleTextInput(it)
                it.isClickable = false
            }
            yBtn.setOnClickListener{
                handleTextInput(it)
                it.isClickable = false
            }
            zBtn.setOnClickListener{
                handleTextInput(it)
                it.isClickable = false
            }
            nextBtn.setOnClickListener {
                resetGame()
                setButtonsClickable(true)
            }
        }
    }

    fun handleTextInput(view: View)
    {
        if(viewModel.solvePuzzle((view as TextView).text.toString())==true)
        {
            if(viewModel.checkWin())
            {
                setButtonsClickable(false)
            }
        }
        else
        {
            if (viewModel.checkGameOver()==true)
            {
                viewModel.revealWord()
                setButtonsClickable(false)
            }

        }
        //one time clickable
        (view as TextView).isClickable = false
    }

    fun setButtonsClickable(flag:Boolean){
        binding.apply {
            nextBtn.visibility =  if(flag) View.INVISIBLE else View.VISIBLE
            aBtn.isClickable = flag
            bBtn.isClickable = flag
            cBtn.isClickable = flag
            dBtn.isClickable = flag
            eBtn.isClickable = flag
            fBtn.isClickable = flag
            gBtn.isClickable = flag
            hBtn.isClickable = flag
            jBtn.isClickable = flag
            kBtn.isClickable = flag
            lBtn.isClickable = flag
            mBtn.isClickable = flag
            nBtn.isClickable = flag
            oBtn.isClickable = flag
            pBtn.isClickable = flag
            qBtn.isClickable = flag
            rBtn.isClickable = flag
            sBtn.isClickable = flag
            tBtn.isClickable = flag
            uBtn.isClickable = flag
            vBtn.isClickable = flag
            wBtn.isClickable = flag
            xBtn.isClickable = flag
            yBtn.isClickable = flag
            zBtn.isClickable = flag
        }
    }

    private fun resetGame() {
        viewModel.resetHangmanState()
        viewModel.nextWord()
        //show all buttons
        //hide next button
    }
}