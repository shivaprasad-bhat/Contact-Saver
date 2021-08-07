package com.jb.svb.contactsaver.core

class LiveDataValidatorResolver(private val validators: List<LiveDataValidator<*>>) {
    fun isValid(): Boolean {
        validators.forEach {
            if (!it.isValid()) {
                return false
            }
        }
        return true
    }
}