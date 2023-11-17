package com.example.roomdbtutorial.viewmodels.admin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomdbtutorial.db.admin.AdminRepository

class AdminViewModelFactory(private val adminRepository: AdminRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AdminViewModel::class.java)) {
            return AdminViewModel(adminRepository) as T
        }
        throw IllegalArgumentException("Unknown Admin ViewModel class")
    }
}