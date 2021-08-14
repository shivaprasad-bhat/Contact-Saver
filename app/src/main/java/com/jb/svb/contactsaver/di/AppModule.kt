package com.jb.svb.contactsaver.di

import android.content.Context
import com.jb.svb.contactsaver.persistance.ContactDatabase
import com.jb.svb.contactsaver.repositories.ContactRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = ContactDatabase.getInstance(context)

    @Provides
    fun provideContactRepository(
        contactDatabase: ContactDatabase
    ): ContactRepository = ContactRepository(contactDatabase.dao)

    // TODO() = create same obj
}