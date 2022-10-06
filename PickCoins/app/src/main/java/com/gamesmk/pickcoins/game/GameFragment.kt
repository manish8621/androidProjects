package com.gamesmk.pickcoins.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.gamesmk.pickcoins.R
import com.gamesmk.pickcoins.databinding.ActivityMainBinding
import com.gamesmk.pickcoins.databinding.FragmentGameBinding


class GameFragment : Fragment() {

    lateinit var viewModel: GameViewModel
    lateinit var binding:FragmentGameBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[GameViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setOnclickListeners()
        setObservers()
        hideResetButton()
    }

    private fun setObservers() {
        viewModel.player1Score.observe(viewLifecycleOwner,Observer{
            val scoreText = "${viewModel.coinText}$it"
            binding.player1ScoreTv.text = scoreText
        })
        viewModel.player2Score.observe(viewLifecycleOwner,Observer{
            val scoreText = "${viewModel.coinText}$it"
            binding.player2ScoreTv.text = scoreText
        })
        viewModel.totalCoins.observe(viewLifecycleOwner,Observer{
            binding.totalCoinsTv.text = it.toString()
        })
        viewModel.gameFinished.observe(viewLifecycleOwner,Observer{
            if(it==true)
                {
                    //to result
                    val player1Score  = "player1 ${ viewModel.player1Score.value } / ${ viewModel.coins }"
                    val player2Score  = "player2 ${ viewModel.player2Score.value } / ${ viewModel.coins }"
                    findNavController().navigate(GameFragmentDirections.actionGameFragmentToResultFragment(viewModel.getWinner(),player1Score,player2Score))
                    viewModel.resetAll()
                }

        })
    }

    private fun setOnclickListeners() {
        binding.player1HandIv.setOnClickListener{
            handleInput(it as ImageView)
        }
        binding.player2HandIv.setOnClickListener{
            handleInput(it as ImageView)
        }
    }

    private fun handleInput(iv:ImageView) {

            //update score
            if (iv.tag.toString().equals("player1")) {
                viewModel.updatePlayer1Score()
                // animate
                iv.animate().translationY(200f).setDuration(10).withEndAction() {
                    iv.animate().translationY(-100f)
                }.setDuration(10).start()
            }
            else {
                viewModel.updatePlayer2Score()
                // animate
                iv.animate().translationY(-200f).setDuration(10).withEndAction() {
                    iv.animate().translationY(100f)
                }.setDuration(10).start()
            }

    }

    private fun showResetButton() {
        binding.resetBtn.visibility = View.VISIBLE
    }

    private fun hideResetButton() {
        binding.resetBtn.visibility = View.INVISIBLE
    }
}