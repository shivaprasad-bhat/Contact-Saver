package com.jb.svb.contactsaver.viewmodels

import android.util.Patterns
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jb.svb.contactsaver.core.LiveDataValidator
import com.jb.svb.contactsaver.core.LiveDataValidatorResolver
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class NewContactViewModel @Inject constructor() : ViewModel() {
    val contactName: MutableLiveData<String> = MutableLiveData()
    val mobileNumber: MutableLiveData<String> = MutableLiveData()
    val emailId: MutableLiveData<String> = MutableLiveData()

    val isFormValid: MediatorLiveData<Boolean> = MediatorLiveData()

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


}