package com.jb.svb.contactsaver.persistance.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class ContactEntity(
    val contactName: String,
    val mobileNumber: Long,
    val emailId: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = -1
)
