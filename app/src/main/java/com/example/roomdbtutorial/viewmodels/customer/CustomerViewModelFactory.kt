package com.example.roomdbtutorial.viewmodels.customer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomdbtutorial.db.customer.CustomerRepository

class CustomerViewModelFactory(private val customerRepository: CustomerRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CustomerViewModel::class.java)) {
            return CustomerViewModel(customerRepository) as T
        }
        throw IllegalArgumentException("Unknown Customer ViewModel class")
    }
}