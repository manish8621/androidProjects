package com.example.trivia.gameWin

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.trivia.R
import com.example.trivia.databinding.FragmentGameWinBinding
import com.example.trivia.gameOver.GameOverFragmentArgs


class GameWinFragment : Fragment() {
    lateinit var binding: FragmentGameWinBinding
    lateinit var viewModel:GameWinViewModel
    var totalQuestions = 1;
    var correctAnswers = 1
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding  = FragmentGameWinBinding.inflate(inflater,container,false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val args = GameWinFragmentArgs.fromBundle(it)
            totalQuestions = args.totalQuestions
            correctAnswers = args.correctAnswers
        }
        //create factory
        val factory = GameWinViewModelFactory(correctAnswers,totalQuestions)
        //init view model
        viewModel = ViewModelProvider(this,factory).get(GameWinViewModel::class.java)
        binding.gameWinViewModel = viewModel
        binding.lifecycleOwner = this
    }


    private fun getShareIntent():Intent
    {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT,getString(R.string.success_text,correctAnswers,totalQuestions))
        return shareIntent
    }
    private fun shareSuccess()
    {
        startActivity(getShareIntent())
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.winner_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }
}