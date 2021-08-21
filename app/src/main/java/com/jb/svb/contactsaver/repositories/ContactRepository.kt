package com.jb.svb.contactsaver.repositories

import com.jb.svb.contactsaver.core.CustomResponse
import com.jb.svb.contactsaver.models.Contact
import com.jb.svb.contactsaver.models.asDatabaseModel
import com.jb.svb.contactsaver.persistance.dao.ContactDao
import com.jb.svb.contactsaver.persistance.entities.ContactEntity

class ContactRepository(
    private val contactDao: ContactDao
) {

    suspend fun addContact(contact: Contact): CustomResponse<Long> {
        val entity: ContactEntity = contact.asDatabaseModel()
        return try {
            val response = contactDao.insert(entity)
            CustomResponse.Success(response)
        } catch (e: Exception) {
            CustomResponse.Failure(e.message!!)
        }
    }

}