package com.jb.svb.contactsaver.viewmodels

import androidx.lifecycle.ViewModel
import com.jb.svb.contactsaver.core.SingeLiveEvent

class HomeViewModel : ViewModel() {

    val navigateToCreateContact = SingeLiveEvent<Unit>()

    fun navigateToCreateContact() {
        navigateToCreateContact.call()
    }
}