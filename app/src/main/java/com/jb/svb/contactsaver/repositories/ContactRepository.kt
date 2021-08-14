package com.jb.svb.contactsaver.repositories

import com.jb.svb.contactsaver.models.Contact
import com.jb.svb.contactsaver.models.asDatabaseModel
import com.jb.svb.contactsaver.persistance.dao.ContactDao
import com.jb.svb.contactsaver.persistance.entities.ContactEntity

class ContactRepository(
    private val contactDao: ContactDao
) {

    suspend fun addContact(contact: Contact) {
        val entity: ContactEntity = contact.asDatabaseModel()
        contactDao.insert(entity)
    }

}