package com.jb.svb.contactsaver.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.jb.svb.contactsaver.R
import com.jb.svb.contactsaver.databinding.FragmentHomeBinding
import com.jb.svb.contactsaver.viewmodels.HomeViewModel

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        binding.apply {
            homeViewModel = viewModel
            lifecycleOwner = this@HomeFragment.viewLifecycleOwner
        }

        viewModel.navigateToCreateContact.observe(viewLifecycleOwner) {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToNewContactFragment(
                )
            )
        }
    }

}