package com.example.roomdbtutorial.viewmodels.order

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomdbtutorial.db.order.OrderRepository

class OrderViewModelFactory(private val orderRepository: OrderRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OrderViewModel::class.java)) {
            return OrderViewModel(orderRepository) as T
        }
        throw IllegalArgumentException("Unknown Order ViewModel class")
    }
}