package com.example.roomdbtutorial.viewmodels.admin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdbtutorial.db.admin.AdminRepository
import com.example.roomdbtutorial.models.Admin
import kotlinx.coroutines.launch

class AdminViewModel(private val adminRepository: AdminRepository):ViewModel() {
    suspend fun getAllAdmins():List<Admin>{
        return adminRepository.getAllAdmins()
    }

    suspend fun insertAdmin(admin: Admin){
        viewModelScope.launch{
            adminRepository.insertAdmin(admin)
        }
    }

    suspend fun updateAdmin(admin: Admin){
        viewModelScope.launch {
            adminRepository.updateAdmin(admin)
        }
    }

    suspend fun deleteAdmin(admin: Admin){
        viewModelScope.launch {
            adminRepository.deleteAdmin(admin)
        }
    }
}