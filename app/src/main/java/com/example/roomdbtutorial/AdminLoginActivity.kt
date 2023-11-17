package com.example.roomdbtutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.roomdbtutorial.db.AppDatabase
import com.example.roomdbtutorial.db.admin.AdminRepository
import com.example.roomdbtutorial.models.Admin
import com.example.roomdbtutorial.viewmodels.admin.AdminViewModel
import com.example.roomdbtutorial.viewmodels.admin.AdminViewModelFactory
import kotlinx.coroutines.launch

class AdminLoginActivity : AppCompatActivity() {
    private lateinit var adminViewModel: AdminViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login)

        supportActionBar?.apply {
            title = "Admin Authentication" // Set the desired title here
            setDisplayHomeAsUpEnabled(true)
        }

        val appDatabase = AppDatabase.getDatabaseInstance(applicationContext)
        Log.d("App Database", "App Database Instance Created $appDatabase")

        val adminRepository = AdminRepository(appDatabase.adminDao())
        val adminViewModelFactory = AdminViewModelFactory(adminRepository)
        adminViewModel = ViewModelProvider(this, adminViewModelFactory)[AdminViewModel::class.java]

        val adminFirstName = findViewById<EditText>(R.id.adminFirstNameEditText)
        val adminLastName = findViewById<EditText>(R.id.adminLastNameEditText)
        val adminUserName = findViewById<EditText>(R.id.adminUsernameEditText)
        val adminPassword = findViewById<EditText>(R.id.adminPasswordEditText)
        val adminRegisterButton = findViewById<Button>(R.id.adminRegisterButton)

        adminRegisterButton.setOnClickListener {
            lifecycleScope.launch {
                Log.d("Coroutine", "Coroutine Started")
                if (adminFirstName.text.trim().isNotEmpty()&&
                    adminLastName.text.trim().isNotEmpty()&&
                    adminPassword.text.trim().isNotEmpty()
                ){

                    val firstName = adminFirstName.text.trim().toString()
                    val lastName = adminLastName.text.trim().toString()
                    val password = adminPassword.text.toString()
                    val userName = if (adminUserName.text.trim().isNotEmpty()) adminUserName.text.trim().toString() else adminFirstName.text.trim().toString().toLowerCase()+"_"+adminLastName.text.trim().toString().toLowerCase()

                    val newAdmin = Admin(userName = userName, firstname = firstName, lastname = lastName, password = password)
                    Log.d("newAdmin",newAdmin.toString())

                    adminViewModel.insertAdmin(newAdmin)

                }
                else{
                    if (adminFirstName.text.trim().isEmpty()){
                        adminFirstName.error = "Enter your first name"
                    }
                    if (adminLastName.text.trim().isEmpty()){
                        adminLastName.error = "Enter your last name"
                    }
                    if (adminPassword.text.trim().isEmpty()){
                        adminPassword.error = "Enter a strong password"
                    }

                }
                Log.d("Coroutine", "Coroutine Ended!!")
            }

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}