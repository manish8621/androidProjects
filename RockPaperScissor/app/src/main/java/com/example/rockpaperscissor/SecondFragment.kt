package com.example.rockpaperscissor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.rockpaperscissor.databinding.FragmentFirstBinding
import com.example.rockpaperscissor.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    lateinit var binding:FragmentSecondBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentSecondBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.nextButton.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_lastFragment)
        }
    }
}