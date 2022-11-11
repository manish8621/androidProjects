package com.mk.application3.result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mk.application3.ContactClickListener
import com.mk.application3.ContactsAdapter
import com.mk.application3.database.ContactDatabase
import com.mk.application3.databinding.FragmentResultBinding


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

        //set adapter
        val adapter = ContactsAdapter(ContactClickListener{
            Toast.makeText(context,it,Toast.LENGTH_SHORT).show()
        })

        //setObservers
        viewModel.contacts.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.addHeaderAndSubmitList(it)
            }
        })

        //recycler view
        binding.recyclerView.adapter = adapter
    }

    private fun setObservers() {

    }
}