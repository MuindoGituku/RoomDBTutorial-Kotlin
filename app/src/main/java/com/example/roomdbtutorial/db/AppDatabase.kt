package com.example.roomdbtutorial.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdbtutorial.db.admin.AdminDao
import com.example.roomdbtutorial.db.customer.CustomerDao
import com.example.roomdbtutorial.db.order.OrderDao
import com.example.roomdbtutorial.db.pizza.PizzaDao
import com.example.roomdbtutorial.models.Admin
import com.example.roomdbtutorial.models.Customer
import com.example.roomdbtutorial.models.Order
import com.example.roomdbtutorial.models.Pizza

@Database(entities = [Customer::class,Admin::class,Pizza::class,Order::class], version = 2)
abstract class AppDatabase: RoomDatabase() {
    abstract fun customerDao():CustomerDao
    abstract fun adminDao():AdminDao
    abstract fun pizzaDao():PizzaDao
    abstract fun orderDao():OrderDao

    companion object {
        private var INSTANCE:AppDatabase? = null

        fun getDatabaseInstance(context: Context):AppDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "pizza_orders_manager",
                )
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}