package com.hardcoderz.androidmvvmsample.repositories

import android.arch.lifecycle.LiveData
import com.hardcoderz.androidmvvmsample.db.AppDatabase
import com.hardcoderz.androidmvvmsample.models.Contact

class ContactRepository(private val database: AppDatabase) {

    fun insert(contact: Contact) {
        database.runInTransaction {
            database.contactDao().insert(contact)
        }
    }

    fun getContacts(): LiveData<List<Contact>> = database.contactDao().loadContacts()
}