package com.jb.svb.contactsaver.models

import android.os.Parcelable
import com.jb.svb.contactsaver.persistance.entities.ContactEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contact(
    val name: String,
    val email: String,
    val mobileNo: Long,
    val id: Int = -1
) : Parcelable

fun Contact.asDatabaseModel(): ContactEntity {
    return ContactEntity(name, mobileNo, email)
}