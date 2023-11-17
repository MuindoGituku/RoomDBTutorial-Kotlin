package com.example.roomdbtutorial.viewmodels.pizza

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomdbtutorial.db.pizza.PizzaRepository

class PizzaViewModelFactory(private val pizzaRepository: PizzaRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PizzaViewModel::class.java)) {
            return PizzaViewModel(pizzaRepository) as T
        }
        throw IllegalArgumentException("Unknown Pizza ViewModel class")
    }
}