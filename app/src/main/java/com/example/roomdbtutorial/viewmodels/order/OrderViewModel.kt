package com.example.roomdbtutorial.viewmodels.order

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdbtutorial.db.order.OrderRepository
import com.example.roomdbtutorial.models.Order
import kotlinx.coroutines.launch

class OrderViewModel(private val orderRepository: OrderRepository):ViewModel() {
    suspend fun getAllOrders():List<Order>{
        return orderRepository.getAllOrders()
    }

    suspend fun insertOrder(order: Order){
        viewModelScope.launch{
            orderRepository.insertOrder(order)
        }
    }

    suspend fun updateOrder(order: Order){
        viewModelScope.launch {
            orderRepository.updateOrder(order)
        }
    }

    suspend fun deleteOrder(order: Order){
        viewModelScope.launch {
            orderRepository.deleteOrder(order)
        }
    }
}