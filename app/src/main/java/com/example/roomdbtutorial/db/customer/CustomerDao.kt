package com.example.roomdbtutorial.db.customer

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.roomdbtutorial.models.Customer

@Dao
interface CustomerDao {
    @Insert
    suspend fun insertCustomer(customer: Customer)

    @Query("SELECT * FROM customers")
    suspend fun getAllCustomers(): List<Customer>

    @Update
    suspend fun updateCustomer(customer: Customer)

    @Delete
    suspend fun deleteCustomer(customer: Customer)
}