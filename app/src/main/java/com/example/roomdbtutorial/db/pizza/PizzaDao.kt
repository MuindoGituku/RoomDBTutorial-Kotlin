package com.example.roomdbtutorial.db.pizza

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.roomdbtutorial.models.Pizza

@Dao
interface PizzaDao {
    @Insert
    suspend fun insertPizza(pizza: Pizza)

    @Query("SELECT * FROM pizzas")
    suspend fun getAllPizzas(): List<Pizza>

    @Update
    suspend fun updatePizza(pizza: Pizza)

    @Delete
    suspend fun deletePizza(pizza: Pizza)
}