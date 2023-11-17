package com.example.roomdbtutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.roomdbtutorial.db.AppDatabase
import com.example.roomdbtutorial.db.customer.CustomerRepository
import com.example.roomdbtutorial.models.Customer
import com.example.roomdbtutorial.viewmodels.customer.CustomerViewModel
import com.example.roomdbtutorial.viewmodels.customer.CustomerViewModelFactory
import kotlinx.coroutines.launch

class CustomerLoginActivity : AppCompatActivity() {
    private lateinit var customerViewModel: CustomerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_login)

        supportActionBar?.apply {
            title = "Customer Registration" // Set the desired title here
            setDisplayHomeAsUpEnabled(true)
        }

        val appDatabase = AppDatabase.getDatabaseInstance(applicationContext)
        Log.d("App Database", "App Database Instance Created $appDatabase")

        val customerRepository = CustomerRepository(appDatabase.customerDao())
        val customerViewModelFactory = CustomerViewModelFactory(customerRepository)
        customerViewModel = ViewModelProvider(this, customerViewModelFactory)[CustomerViewModel::class.java]

        val customerFirstName = findViewById<EditText>(R.id.customerFirstNameEditText)
        val customerLastName = findViewById<EditText>(R.id.customerLastNameEditText)
        val customerUserName = findViewById<EditText>(R.id.customerUsernameEditText)
        val customerHomeAddress = findViewById<EditText>(R.id.customerAddressEditText)
        val customerCity = findViewById<EditText>(R.id.customerCityEditText)
        val customerPostalCode = findViewById<EditText>(R.id.customerPostalCodeEditText)
        val customerPassword = findViewById<EditText>(R.id.customerPasswordEditText)
        val customerRegisterButton = findViewById<Button>(R.id.customerRegisterButton)

        customerRegisterButton.setOnClickListener {
            lifecycleScope.launch {
                Log.d("Coroutine", "Coroutine Started")
                if (customerFirstName.text.trim().isNotEmpty()&&
                    customerLastName.text.trim().isNotEmpty()&&
                    customerHomeAddress.text.trim().isNotEmpty()&&
                    customerCity.text.trim().isNotEmpty()&&
                    customerPostalCode.text.trim().isNotEmpty()&&
                    customerPassword.text.trim().isNotEmpty()
                    ){

                    val firstName = customerFirstName.text.trim().toString()
                    val lastName = customerLastName.text.trim().toString()
                    val address = customerHomeAddress.text.trim().toString()
                    val password = customerPassword.text.toString()
                    val city = customerCity.text.trim().toString()
                    val postalCode = customerPostalCode.text.trim().toString()
                    val userName = if (customerUserName.text.trim().isNotEmpty()) customerUserName.text.trim().toString() else customerFirstName.text.trim().toString().toLowerCase()+"_"+customerLastName.text.trim().toString().toLowerCase()

                    val newCustomer = Customer(userName = userName, firstname = firstName, lastname = lastName, address = address, password = password, city = city, postalCode = postalCode)
                    Log.d("newCustomer",newCustomer.toString())

                    customerViewModel.insertCustomer(newCustomer)

                    val intent = Intent(this, CustomerDashboardActivity::class.java)
                    startActivity(intent)

                }
                else{
                    if (customerFirstName.text.trim().isEmpty()){
                        customerFirstName.error = "Enter your first name"
                    }
                    if (customerLastName.text.trim().isEmpty()){
                        customerLastName.error = "Enter your last name"
                    }
                    if (customerHomeAddress.text.trim().isEmpty()){
                        customerHomeAddress.error = "Enter your home address"
                    }
                    if (customerCity.text.trim().isEmpty()){
                        customerCity.error = "Enter your city name"
                    }
                    if (customerPostalCode.text.trim().isEmpty()){
                        customerPostalCode.error = "Enter your postal code"
                    }
                    if (customerPassword.text.trim().isEmpty()){
                        customerPassword.error = "Enter a strong password"
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