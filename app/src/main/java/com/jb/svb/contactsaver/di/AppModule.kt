package com.jb.svb.contactsaver.di

import android.content.Context
import com.jb.svb.contactsaver.BuildConfig
import com.jb.svb.contactsaver.persistance.ContactDatabase
import com.jb.svb.contactsaver.repositories.ContactRepository
import com.jb.svb.contactsaver.utilities.PASSPHRASE_DB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ContactDatabase {
        val factory = if (!BuildConfig.DEBUG) provideEncryptionFactoryObject() else null
        return ContactDatabase.getInstance(context, factory)
    }

    @Provides
    fun provideContactRepository(
        contactDatabase: ContactDatabase
    ): ContactRepository = ContactRepository(contactDatabase.dao)

    private fun provideEncryptionFactoryObject(): SupportFactory {
        val bytes = SQLiteDatabase.getBytes(PASSPHRASE_DB.toCharArray())
        return SupportFactory(bytes)
    }

    // TODO() = create same obj
}