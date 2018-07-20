package com.hardcoderz.androidmvvmsample.addcontact

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.hardcoderz.androidmvvmsample.db.AppDatabase
import com.hardcoderz.androidmvvmsample.models.Contact
import com.hardcoderz.androidmvvmsample.repositories.ContactRepository

class AddContactViewModel(app: Application) : AndroidViewModel(app) {

    val isAdded = MutableLiveData<Boolean>()

    private var database: AppDatabase? = AppDatabase.getInstance(getApplication())

    fun addContact(contact: Contact) {
        val db = database
        if (db != null) {
            Thread(Runnable {
                val contactRepo = ContactRepository(db)
                contactRepo.insert(contact)

                isAdded.postValue(true)
            }).start()
        }
    }
}