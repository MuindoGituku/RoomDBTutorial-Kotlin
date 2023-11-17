package com.example.roomdbtutorial.db.admin

import com.example.roomdbtutorial.models.Admin


class AdminRepository(private val adminDao: AdminDao) {
    suspend fun insertAdmin(admin: Admin){
        adminDao.insertAdmin(admin)
    }
    suspend fun getAllAdmins():List<Admin>{
        return adminDao.getAllAdmins()
    }
    suspend fun updateAdmin(admin: Admin){
        adminDao.updateAdmin(admin)
    }
    suspend fun deleteAdmin(admin: Admin){
        adminDao.deleteAdmin(admin)
    }
}