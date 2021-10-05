package com.jb.svb.contactsaver.ui.dialognotifier

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import com.jb.svb.contactsaver.R
import com.jb.svb.contactsaver.databinding.DialogContactQuickActionBinding
import com.jb.svb.contactsaver.models.Contact

class ContactQuickActionDialog(
    private val listener: ContactQuickActionDialogListener
) : DialogFragment(R.layout.dialog_contact_quick_action),
    View.OnClickListener {
    private lateinit var binding: DialogContactQuickActionBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DialogContactQuickActionBinding.bind(view)
        arguments?.getParcelable<Contact>("contact")?.let { contact ->
            binding.apply {
                contactNameTv.text = contact.name
                contactMobileTv.text = contact.mobileNo.toString()
                contactEmailTv.text = contact.email
            }
        }
        binding.buttonDelete.setOnClickListener(this)
        binding.buttonEdit.setOnClickListener(this)
        binding.buttonClose.setOnClickListener(this)
        binding.contactEmailTv.setOnClickListener(this)
        binding.contactMobileTv.setOnClickListener(this)
    }


    override fun onClick(view: View) {
        when (view.id) {
            binding.buttonDelete.id -> {
                listener.onDelete()
            }
            binding.buttonEdit.id -> {
                listener.onEdit()
            }
            binding.contactEmailTv.id -> {
                listener.onEmail()
            }
            binding.contactMobileTv.id -> {
                listener.onMobileNumber()
            }
        }
        dismiss()
    }
}