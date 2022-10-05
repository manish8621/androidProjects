package com.example.rockpaperscissor.game
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.rockpaperscissor.R
import com.example.rockpaperscissor.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    lateinit var binding:FragmentGameBinding
    lateinit var viewModel: GameViewModel
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
        setOnclickListeners()
        setObservers()

    }

    private fun setObservers() {
        viewModel.computerMove.observe(viewLifecycleOwner, Observer(){
            binding.computerMoveIv.setImageResource(textToSourceId(it))
        })
        viewModel.playerMove.observe(viewLifecycleOwner, Observer(){
            binding.playerMoveIv.setImageResource(textToSourceId(it))
        })
    }

    private fun setOnclickListeners() {

        binding.rockBtn.setOnClickListener {
            viewModel.handleInput(it.tag.toString())
        }
        binding.paperBtn.setOnClickListener {
            viewModel.handleInput(it.tag.toString())
        }
        binding.scissorBtn.setOnClickListener {
            viewModel.handleInput(it.tag.toString())
        }
    }
    private fun textToSourceId(move: String): Int =
        when(move){
            "Rock" -> R.drawable.rock
            "Paper" -> R.drawable.paper
            "Scissor" -> R.drawable.scissor
            else -> {
                R.drawable.ready}
        }


}