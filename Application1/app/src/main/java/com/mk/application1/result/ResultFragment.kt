package com.mk.application1.result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.mk.application1.R
import com.mk.application1.database.ContactDatabase
import com.mk.application1.databinding.FragmentHomeBinding
import com.mk.application1.databinding.FragmentResultBinding
import com.mk.application1.home.HomeViewModel


class ResultFragment : Fragment() {
    lateinit var binding : FragmentResultBinding
    lateinit var viewModel:ResultViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val application = requireNotNull(activity).application
        val datasource = ContactDatabase.getInstance(application).dataBaseDao
        val factory = ResultViewModelFactory(datasource,application)
        viewModel = ViewModelProvider(this,factory)[ResultViewModel::class.java]
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }
}