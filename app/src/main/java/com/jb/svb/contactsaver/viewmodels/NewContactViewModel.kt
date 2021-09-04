package com.jb.svb.contactsaver.viewmodels

import android.util.Patterns
import android.view.View
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jb.svb.contactsaver.core.CustomResponse
import com.jb.svb.contactsaver.core.LiveDataValidator
import com.jb.svb.contactsaver.core.LiveDataValidatorResolver
import com.jb.svb.contactsaver.models.Contact
import com.jb.svb.contactsaver.repositories.ContactRepository
import com.jb.svb.contactsaver.utilities.hideKeyBoard
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class NewContactViewModel @Inject
constructor(
    private val repository: ContactRepository
) : ViewModel() {

    val newContactResponse = MutableLiveData<CustomResponse<Long>>()

    val contactName: MutableLiveData<String> = MutableLiveData()
    val mobileNumber: MutableLiveData<String> = MutableLiveData()
    val emailId: MutableLiveData<String> = MutableLiveData()

    val isFormValid: MediatorLiveData<Boolean> = MediatorLiveData()

    val showProgressBar: MutableLiveData<Boolean> = MutableLiveData(false)

    // Live Data Validator
    val contactNameValidator = LiveDataValidator(contactName).apply {
        addRule("It is Required") {
            (it as String?).isNullOrBlank()
        }
    }

    val mobileValidator = LiveDataValidator(mobileNumber).apply {
        addRule("Is Required") {
            (it as String?).isNullOrBlank()
        }
        addRule("Valid Number needed") {
            (it as String).length != 10
        }
    }

    val emailValidator = LiveDataValidator(emailId).apply {
        addRule("Is Required") {
            (it as String?).isNullOrBlank()
        }
        addRule("Valid Email needed") {
            !Patterns.EMAIL_ADDRESS.matcher((it as String)).matches()
        }
    }


    init {
        isFormValid.value = false
        isFormValid.addSource(contactName) {
            validateForm()
        }

        isFormValid.addSource(mobileNumber) {
            validateForm()
        }

        isFormValid.addSource(emailId) {
            validateForm()
        }
    }

    private fun validateForm() {
        val validatorResolver =
            LiveDataValidatorResolver(listOf(contactNameValidator, mobileValidator, emailValidator))

        isFormValid.value = validatorResolver.isValid()
    }

    fun validateInput() {
        Timber.i("User Input: Name - ${contactName.value}, Mobile Number - ${mobileNumber.value}, Email Id - ${emailId.value}")
        mobileValidator.isValid()
    }


    fun addNewContact(view: View) {
        view.hideKeyBoard()
        showProgressBar.postValue(true)

        viewModelScope.launch {
            val model = Contact(contactName.value!!, emailId.value!!, mobileNumber.value!!.toLong())
            val response = repository.addContact(model)
            showProgressBar.postValue(false)
            newContactResponse.postValue(response)
        }

    }
}