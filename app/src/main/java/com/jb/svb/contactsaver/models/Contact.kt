package com.jb.svb.contactsaver.models

data class Contact(
    val name: String,
    val email: String,
    val mobileNo: Long,
    val id: Int = -1
)
