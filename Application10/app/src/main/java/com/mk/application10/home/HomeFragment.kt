package com.mk.application10.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.mk.application10.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var viewModel: HomeViewModel
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        binding.viewModel = viewModel

        val adapter = Adapter()
        viewModel.animeList.observe(viewLifecycleOwner, Observer{
            adapter.submitList(it)
        })
        with(binding){
            recyclerView.layoutManager = GridLayoutManager(activity,2)
            recyclerView.adapter = adapter
        }

return binding.root
    }

}