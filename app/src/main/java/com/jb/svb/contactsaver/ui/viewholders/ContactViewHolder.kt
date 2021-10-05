package com.jb.svb.contactsaver.ui.viewholders

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.jb.svb.contactsaver.databinding.LayoutContactListItemBinding
import com.jb.svb.contactsaver.models.Contact
import com.jb.svb.contactsaver.ui.dialognotifier.ContactQuickActionDialog
import com.jb.svb.contactsaver.ui.dialognotifier.ContactQuickActionDialogListener
import com.jb.svb.contactsaver.utilities.showToast

class ContactViewHolder(
    private val binding: LayoutContactListItemBinding
) : RecyclerView.ViewHolder(binding.root), ContactQuickActionDialogListener {
    private val dialog: ContactQuickActionDialog = ContactQuickActionDialog(this)
    private lateinit var context: Context

    fun bind(contact: Contact) {
        this.context = binding.root.context
        binding.contact = contact

        binding.root.setOnLongClickListener {
            val bundle = bundleOf(Pair("contact", contact))
            dialog.arguments = bundle
            dialog.show(
                (context.applicationContext as AppCompatActivity).supportFragmentManager,
                "CustomQuickAction"
            )
            true
        }

    }

    override fun onEdit() {
        context.showToast("Edit")
    }

    override fun onDelete() {
        context.showToast("Delete")
    }

    override fun onMobileNumber() {
        context.showToast("Mobile Number")
    }

    override fun onEmail() {
        context.showToast("Email")
    }
}