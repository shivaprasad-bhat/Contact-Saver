package com.jb.svb.contactsaver.core

import androidx.lifecycle.MutableLiveData

typealias Predicate = (value: Any?) -> Boolean

class LiveDataValidator<T>(private val liveData: MutableLiveData<T>) {
    private val error = mutableListOf<String>()
    val errorLatest = MutableLiveData<String>()
    private var rules = mutableListOf<Predicate>()

    fun addRule(errorMessage: String, predicate: Predicate) {
        error.add(errorMessage)
        rules.add(predicate)
    }

    fun isValid(): Boolean {
        rules.forEachIndexed { index, function ->
            if (function(liveData.value)) {
                errorLatest.value = error[index]
                return false
            }
        }
        errorLatest.value = null
        return true
    }
}

