package com.example.trivia.gameOver

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.trivia.R
import com.example.trivia.databinding.FragmentGameOverBinding


class GameOverFragment : Fragment() {
    lateinit var binding: FragmentGameOverBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding  = FragmentGameOverBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val args = GameOverFragmentArgs.fromBundle(it)
            Toast.makeText(context,"your score : ${args.correctAnswers}/${args.totalQuestions}",Toast.LENGTH_SHORT).show()

        }
        binding.tryAgainBtn.setOnClickListener {
            findNavController().popBackStack(R.id.titleFragment,false)
        }
    }
    fun setActionBarTitle(_title:String){
        activity?.let {
            it.title = _title
        }
    }
}