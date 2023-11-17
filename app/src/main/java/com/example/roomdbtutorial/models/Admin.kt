package com.example.roomdbtutorial.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "admins")
data class Admin (
    @PrimaryKey(autoGenerate = true) val employeeId: Int = 0,
    @ColumnInfo(name = "userName") val userName: String,
    @ColumnInfo(name = "password") val password: String,
    @ColumnInfo(name = "firstname") val firstname: String,
    @ColumnInfo(name = "lastname") val lastname: String,
)