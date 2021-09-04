package com.jb.svb.contactsaver.viewmodels

import androidx.lifecycle.ViewModel
import com.jb.svb.contactsaver.core.SingleLiveEvent

class HomeViewModel : ViewModel() {

    val navigateToCreateContact = SingleLiveEvent<Unit>()

    fun navigateToCreateContact() {
        navigateToCreateContact.call()
    }
}