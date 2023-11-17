package com.example.roomdbtutorial.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders")
data class Order (
    @PrimaryKey(autoGenerate = true) val orderId: Int,
    @ColumnInfo(name = "customerId") val customerId: Int,
    @ColumnInfo(name = "productId") val productId: Int,
    @ColumnInfo(name = "employeeId") val employeeId: Int,
    @ColumnInfo(name = "orderDate") val orderDate: String,
    @ColumnInfo(name = "quantity") val quantity: Int,
    @ColumnInfo(name = "status") val status: String,
)