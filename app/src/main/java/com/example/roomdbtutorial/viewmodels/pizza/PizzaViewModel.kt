package com.example.roomdbtutorial.viewmodels.pizza

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdbtutorial.db.pizza.PizzaRepository
import com.example.roomdbtutorial.models.Pizza
import kotlinx.coroutines.launch

class PizzaViewModel(private val pizzaRepository: PizzaRepository):ViewModel() {
    suspend fun getAllPizzas():List<Pizza>{
        return pizzaRepository.getAllPizzas()
    }

    suspend fun insertPizza(pizza: Pizza){
        viewModelScope.launch{
            pizzaRepository.insertPizza(pizza)
        }
    }

    suspend fun updatePizza(pizza: Pizza){
        viewModelScope.launch {
            pizzaRepository.updatePizza(pizza)
        }
    }

    suspend fun deletePizza(pizza: Pizza){
        viewModelScope.launch {
            pizzaRepository.deletePizza(pizza)
        }
    }
}