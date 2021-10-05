package com.jb.svb.contactsaver.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.jb.svb.contactsaver.R
import com.jb.svb.contactsaver.databinding.FragmentHomeBinding
import com.jb.svb.contactsaver.ui.adapters.ContactRecyclerViewAdapter
import com.jb.svb.contactsaver.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        val adapter = ContactRecyclerViewAdapter()

        binding.apply {
            homeViewModel = viewModel
            lifecycleOwner = this@HomeFragment.viewLifecycleOwner
            val itemDecoration =
                DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
            contactRecyclerView.adapter = adapter
            contactRecyclerView.addItemDecoration(itemDecoration)
        }

        viewModel.listOfContacts.asLiveData().observe(viewLifecycleOwner) {
            adapter.itemList = it.toMutableList()
        }

        viewModel.navigateToCreateContact.observe(viewLifecycleOwner) {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToNewContactFragment(
                )
            )
        }
    }
}