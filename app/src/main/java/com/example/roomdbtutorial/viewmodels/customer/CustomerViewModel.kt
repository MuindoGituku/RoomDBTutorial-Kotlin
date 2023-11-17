package com.example.roomdbtutorial.viewmodels.customer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdbtutorial.db.customer.CustomerRepository
import com.example.roomdbtutorial.models.Customer
import kotlinx.coroutines.launch

class CustomerViewModel(private val customerRepository: CustomerRepository):ViewModel() {
    suspend fun getAllCustomers():List<Customer>{
        return customerRepository.getAllCustomers()
    }

     suspend fun insertCustomer(customer: Customer){
        viewModelScope.launch{
            customerRepository.insertCustomer(customer)
        }
    }

    suspend fun updateCustomer(customer: Customer){
        viewModelScope.launch {
            customerRepository.updateCustomer(customer)
        }
    }

    suspend fun deleteCustomer(customer: Customer){
        viewModelScope.launch {
            customerRepository.deleteCustomer(customer)
        }
    }
}