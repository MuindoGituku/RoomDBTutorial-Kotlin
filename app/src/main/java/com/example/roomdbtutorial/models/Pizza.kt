package com.example.roomdbtutorial.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pizzas")
data class Pizza (
    @PrimaryKey(autoGenerate = true) val productId: Int,
    @ColumnInfo(name = "pizzaName") val pizzaName: String,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "category") val category: String,
)