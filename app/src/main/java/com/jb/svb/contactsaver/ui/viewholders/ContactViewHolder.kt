package com.jb.svb.contactsaver.ui.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.jb.svb.contactsaver.databinding.LayoutContactListItemBinding
import com.jb.svb.contactsaver.models.Contact
import timber.log.Timber

class ContactViewHolder(
    private val binding: LayoutContactListItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(contact: Contact) {
        Timber.d("$contact")
        binding.contact = contact
    }
}