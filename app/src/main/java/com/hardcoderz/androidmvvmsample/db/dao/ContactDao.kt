package com.hardcoderz.androidmvvmsample.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.hardcoderz.androidmvvmsample.models.Contact

@Dao
interface ContactDao {
    @Query("SELECT * FROM contacts")
    fun loadContacts(): LiveData<List<Contact>>

    @Insert
    fun insert(contact: Contact)

    @Query("SELECT * FROM contacts WHERE id = :contactId")
    fun loadContact(contactId: Int): LiveData<Contact>
}