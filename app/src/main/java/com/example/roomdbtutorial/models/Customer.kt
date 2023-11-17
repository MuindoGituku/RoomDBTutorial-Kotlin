package com.example.roomdbtutorial.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customers")
data class Customer (
    @PrimaryKey(autoGenerate = true) val customerId: Int = 0,
    @ColumnInfo(name = "userName") val userName: String,
    @ColumnInfo(name = "password") val password: String,
    @ColumnInfo(name = "firstname") val firstname: String,
    @ColumnInfo(name = "lastname") val lastname: String,
    @ColumnInfo(name = "address") val address: String,
    @ColumnInfo(name = "city") val city: String,
    @ColumnInfo(name = "postalCode") val postalCode: String,
)