package com.example.roomdbtutorial.db.pizza

import com.example.roomdbtutorial.models.Pizza


class PizzaRepository(private val pizzaDao: PizzaDao) {
    suspend fun insertPizza(pizza: Pizza){
        pizzaDao.insertPizza(pizza)
    }
    suspend fun getAllPizzas():List<Pizza>{
        return pizzaDao.getAllPizzas()
    }
    suspend fun updatePizza(pizza: Pizza){
        pizzaDao.updatePizza(pizza)
    }
    suspend fun deletePizza(pizza: Pizza){
        pizzaDao.deletePizza(pizza)
    }
}