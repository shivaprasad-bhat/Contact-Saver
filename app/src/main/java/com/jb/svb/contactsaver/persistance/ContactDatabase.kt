package com.jb.svb.contactsaver.persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jb.svb.contactsaver.persistance.dao.ContactDao
import com.jb.svb.contactsaver.persistance.entities.ContactEntity

@Database(entities = [ContactEntity::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {

    abstract val dao: ContactDao

    companion object {
        private const val DATABASE_NAME = "contacts.db"

        private var INSTANCE: ContactDatabase? = null

        fun getInstance(context: Context): ContactDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContactDatabase::class.java,
                    DATABASE_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}