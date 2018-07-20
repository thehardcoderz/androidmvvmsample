package com.hardcoderz.androidmvvmsample.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "contacts")
data class Contact(
        @PrimaryKey(autoGenerate = true)
        var id: Long?,
        @ColumnInfo(name ="name") var name: String,
        @ColumnInfo(name = "mobile_number") var number: String,
        @ColumnInfo(name = "email_address") var email: String
) {
    constructor() : this(null, "", "", "")
}