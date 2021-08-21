package com.jb.svb.contactsaver.core

sealed class CustomResponse<out T> {

    class Success<out T>(val value: T) : CustomResponse<T>()

    class Failure(val message: String) : CustomResponse<Nothing>()
}