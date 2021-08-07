package com.jb.svb.contactsaver.ui

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jb.svb.contactsaver.R
import com.jb.svb.contactsaver.databinding.FragmentNewContactBinding
import com.jb.svb.contactsaver.viewmodels.NewContactViewModel

class NewContactFragment : Fragment(R.layout.fragment_new_contact) {

    private lateinit var binding: FragmentNewContactBinding
    private val viewModel by lazy {
        ViewModelProvider(this).get(NewContactViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

    }

}