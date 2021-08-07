package com.jb.svb.contactsaver.persistance.dao

import androidx.room.*
import com.jb.svb.contactsaver.persistance.entities.ContactEntity

@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(contact: ContactEntity)

    @Update
    suspend fun update(contact: ContactEntity)

    @Delete
    suspend fun delete(contact: ContactEntity)

    @Query("SELECT * FROM contacts")
    suspend fun getAll(): List<ContactEntity>

    @Query("SELECT * FROM contacts WHERE id = :id")
    suspend fun getById(id: Int): ContactEntity

}