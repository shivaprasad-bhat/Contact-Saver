package com.jb.svb.contactsaver.models

import com.jb.svb.contactsaver.persistance.entities.ContactEntity

data class Contact(
    val name: String,
    val email: String,
    val mobileNo: Long,
    val id: Int = -1
)

fun Contact.asDatabaseModel(): ContactEntity {
    return ContactEntity(name, mobileNo, email)
}