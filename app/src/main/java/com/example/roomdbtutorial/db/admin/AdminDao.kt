package com.example.roomdbtutorial.db.admin

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.roomdbtutorial.models.Admin

@Dao
interface AdminDao {
    @Insert
    suspend fun insertAdmin(admin: Admin)

    @Query("SELECT * FROM admins")
    suspend fun getAllAdmins(): List<Admin>

    @Update
    suspend fun updateAdmin(admin: Admin)

    @Delete
    suspend fun deleteAdmin(admin: Admin)
}