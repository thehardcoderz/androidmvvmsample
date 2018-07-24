package com.hardcoderz.androidmvvmsample.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.hardcoderz.androidmvvmsample.db.dao.ContactDao
import com.hardcoderz.androidmvvmsample.models.Contact

abstract class AppDatabase : RoomDatabase() {
    // TODO: Implement AppDatabase
}