package com.jb.svb.contactsaver.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.jb.svb.contactsaver.R
import com.jb.svb.contactsaver.core.CustomResponse
import com.jb.svb.contactsaver.databinding.FragmentNewContactBinding
import com.jb.svb.contactsaver.viewmodels.NewContactViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewContactFragment : Fragment(R.layout.fragment_new_contact) {

    private lateinit var binding: FragmentNewContactBinding
    private val viewModel by viewModels<NewContactViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        observeChanges()
    }

    private fun observeChanges() {
        viewModel.newContactResponse.observe(viewLifecycleOwner) {
            when (it) {
                is CustomResponse.Failure -> {
                    Toast.makeText(
                        requireContext(),
                        it.message,
                        Toast.LENGTH_LONG
                    ).show()
                }
                is CustomResponse.Success -> {

                    Snackbar.make(
                        requireView(),
                        "Record Inserted Successfully.",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

}