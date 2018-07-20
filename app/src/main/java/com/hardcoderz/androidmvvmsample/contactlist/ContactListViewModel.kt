package com.hardcoderz.androidmvvmsample.contactlist

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import com.hardcoderz.androidmvvmsample.db.AppDatabase
import com.hardcoderz.androidmvvmsample.models.Contact
import com.hardcoderz.androidmvvmsample.repositories.ContactRepository

class ContactListViewModel(app: Application) : AndroidViewModel(app) {

    private var database: AppDatabase? = AppDatabase.getInstance(getApplication())
    private var observableContacts = MediatorLiveData<List<Contact>>()

    fun getContactList(): LiveData<List<Contact>> = observableContacts

    init {
        val db = database
        if (db != null) {
            val contactRepo = ContactRepository(db)
            observableContacts.addSource(contactRepo.getContacts(), observableContacts::setValue)
        }
    }
}