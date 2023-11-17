package com.example.roomdbtutorial.db.order

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.roomdbtutorial.models.Order

@Dao
interface OrderDao {
    @Insert
    suspend fun insertOrder(order: Order)

    @Query("SELECT * FROM orders")
    suspend fun getAllOrders(): List<Order>

    @Update
    suspend fun updateOrder(order: Order)

    @Delete
    suspend fun deleteOrder(order: Order)
}