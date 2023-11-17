package com.example.roomdbtutorial.db.order

import com.example.roomdbtutorial.models.Order

class OrderRepository(private val orderDao: OrderDao) {
    suspend fun insertOrder(order: Order){
        orderDao.insertOrder(order)
    }
    suspend fun getAllOrders():List<Order>{
       return orderDao.getAllOrders()
    }
    suspend fun updateOrder(order: Order){
        orderDao.updateOrder(order)
    }
    suspend fun deleteOrder(order: Order){
        orderDao.deleteOrder(order)
    }
}