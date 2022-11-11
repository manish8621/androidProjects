package com.mk.application1.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.mk.application1.R
import com.mk.application1.database.ContactDatabase
import com.mk.application1.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    lateinit var binding : FragmentHomeBinding
    lateinit var viewModel:HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val application = requireNotNull(activity).application
        val dataSource = ContactDatabase.getInstance(application).dataBaseDao
        val factory = HomeViewModelFactory(dataSource,application)
        viewModel = ViewModelProvider(this,factory)[HomeViewModel::class.java]
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.showBtn.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_resultFragment)
        }
    }
}