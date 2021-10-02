package com.jb.svb.contactsaver.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jb.svb.contactsaver.databinding.LayoutContactListItemBinding
import com.jb.svb.contactsaver.models.Contact
import com.jb.svb.contactsaver.ui.viewholders.ContactViewHolder

class ContactRecyclerViewAdapter : RecyclerView.Adapter<ContactViewHolder>() {

    var itemList: MutableList<Contact> = mutableListOf()
        @SuppressLint("NotifyDataSetChanged")
        set(list) {
            with(itemList) {
                clear()
                addAll(list)
                notifyDataSetChanged()
            }
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(
            LayoutContactListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size
}