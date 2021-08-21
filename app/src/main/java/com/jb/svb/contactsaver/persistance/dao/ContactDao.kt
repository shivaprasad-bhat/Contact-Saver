package com.jb.svb.contactsaver.persistance.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.jb.svb.contactsaver.persistance.entities.ContactEntity

@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(contact: ContactEntity): Long

    @Update
    suspend fun update(contact: ContactEntity)

    @Delete
    suspend fun delete(contact: ContactEntity)

    @Query("SELECT * FROM contacts")
    suspend fun getAll(): List<ContactEntity>

    @Query("SELECT * FROM contacts WHERE id = :id")
    suspend fun getById(id: Int): ContactEntity

}