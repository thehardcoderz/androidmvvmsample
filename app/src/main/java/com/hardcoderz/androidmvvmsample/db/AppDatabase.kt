package com.hardcoderz.androidmvvmsample.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.hardcoderz.androidmvvmsample.db.dao.ContactDao
import com.hardcoderz.androidmvvmsample.models.Contact

@Database(entities = [(Contact::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun contactDao(): ContactDao

    companion object {
        var INSTANCE : AppDatabase? = null

        fun getInstance(context: Context) : AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java,
                            "mvvmsample.db"
                    ).build()
                }

                return INSTANCE
            }

            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}