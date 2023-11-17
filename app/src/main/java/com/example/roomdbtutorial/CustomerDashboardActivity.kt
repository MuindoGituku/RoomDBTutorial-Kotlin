package com.example.roomdbtutorial

import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.roomdbtutorial.databinding.ActivityCustomerDashboardBinding

class CustomerDashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomerDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_login)

        //binding = ActivityCustomerDashboardBinding.inflate(layoutInflater)
        //setContentView(binding.root)

        //setSupportActionBar(findViewById(R.id.toolbar))
       // binding.toolbarLayout.title = title
//        binding.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
    }
}