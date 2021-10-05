package com.jb.svb.contactsaver.viewmodels

import androidx.lifecycle.ViewModel
import com.jb.svb.contactsaver.core.SingleLiveEvent
import com.jb.svb.contactsaver.repositories.ContactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: ContactRepository) : ViewModel() {

    val navigateToCreateContact = SingleLiveEvent<Unit>()
    val listOfContacts = repository.contacts

    fun navigateToCreateContact() {
        navigateToCreateContact.call()
    }

}