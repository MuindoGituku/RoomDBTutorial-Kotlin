package com.example.roomdbtutorial.db.customer

import android.util.Log
import com.example.roomdbtutorial.models.Customer


class CustomerRepository(private val customerDao: CustomerDao) {
    suspend fun insertCustomer(customer: Customer){
        Log.d("Insert", "Inserting customer: $customer")
        customerDao.insertCustomer(customer)
    }
    suspend fun getAllCustomers():List<Customer>{
        return customerDao.getAllCustomers()
    }
    suspend fun updateCustomer(customer: Customer){
        Log.d("Update", "Updating customer: $customer")
        customerDao.updateCustomer(customer)
    }
    suspend fun deleteCustomer(customer: Customer){
        Log.d("Delete", "Deleting customer: $customer")
        customerDao.deleteCustomer(customer)
    }
}