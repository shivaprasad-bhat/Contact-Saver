package com.jb.svb.contactsaver.persistance.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jb.svb.contactsaver.models.Contact

@Entity(tableName = "contacts")
data class ContactEntity(
    val contactName: String,
    val mobileNumber: Long,
    val emailId: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)

fun ContactEntity.asModel(): Contact {
    return Contact(contactName, emailId, mobileNumber, id)
}
