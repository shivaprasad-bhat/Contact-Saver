package com.jb.svb.contactsaver.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jb.svb.contactsaver.core.CustomResponse
import com.jb.svb.contactsaver.core.SingleLiveEvent
import com.jb.svb.contactsaver.models.Contact
import com.jb.svb.contactsaver.repositories.ContactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: ContactRepository) : ViewModel() {

    val navigateToCreateContact = SingleLiveEvent<Unit>()
    val contactList = SingleLiveEvent<CustomResponse<List<Contact>>>()

    fun navigateToCreateContact() {
        navigateToCreateContact.call()
    }

    fun getAllContacts() {
        viewModelScope.launch {
            contactList.postValue(repository.getAllContacts())
        }
    }
}