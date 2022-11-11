package com.mk.application2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mk.application2.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit  var viewModel: HomeViewModel
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        //viewModel
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        //recycler view
        val contactsAdaptor = ContactsAdaptor(ContactClickListener{
            Toast.makeText(context,it,Toast.LENGTH_SHORT).show()
        })
        binding.listRecyclerView.adapter = contactsAdaptor
        viewModel.contacts.observe(viewLifecycleOwner, Observer(){
            //instead of assigning the new list to old list use submitList()
//            contactsAdaptor.submitList(it)
            //use a custom function to add header and cast the objects to DataItem
            it?.let{
                contactsAdaptor.addHeaderAndSubmitList(it)
            }
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}