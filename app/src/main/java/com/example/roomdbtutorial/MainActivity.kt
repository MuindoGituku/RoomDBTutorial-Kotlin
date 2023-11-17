package com.example.roomdbtutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val customerLoginButton = findViewById<Button>(R.id.customerLoginButton)
        val adminLoginButton = findViewById<Button>(R.id.adminLoginButton)

        customerLoginButton.setOnClickListener {
            val intent = Intent(this, CustomerLoginActivity::class.java)
            startActivity(intent)
        }

        adminLoginButton.setOnClickListener {
            val intent = Intent(this, AdminLoginActivity::class.java)
            startActivity(intent)
        }
    }
}