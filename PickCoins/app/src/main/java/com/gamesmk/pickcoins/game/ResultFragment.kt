package com.gamesmk.pickcoins.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.gamesmk.pickcoins.R
import com.gamesmk.pickcoins.databinding.FragmentResultBinding


class ResultFragment : Fragment() {
    lateinit var viewModel : ResultViewModel
    lateinit var binding:FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var winner = ""
        var player1Score =""
        var player2Score =""
        arguments?.let {
            var args = ResultFragmentArgs.fromBundle(it)
            winner = args.winner
            player1Score = args.player1Score
            player2Score = args.player2Score

        }
        val factory = ResultViewModelFactory(winner,player1Score,player2Score)
        viewModel = ViewModelProvider(this,factory)[ResultViewModel::class.java]
        setWinner()
        setScoreCard()
    }

    private fun setScoreCard() {
        with(binding)
        {
            player1ScoreTv.text = viewModel.player1Score
            player2ScoreTv.text = viewModel.player2Score
        }
    }

    private fun setWinner() {
        binding.winnerTv.text = viewModel.winner
    }


}