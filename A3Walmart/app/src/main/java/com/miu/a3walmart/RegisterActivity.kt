package com.miu.a3walmart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun register(view: View) {
        var firstName: String = findViewById<EditText>(R.id.first_name).text.toString()
        var lastName: String = findViewById<EditText>(R.id.last_name).text.toString()
        var email: String = findViewById<EditText>(R.id.reg_email_address).text.toString()
        var password: String = findViewById<EditText>(R.id.reg_password).text.toString()


        val intent1 = Intent(this, ShoppingCategoryActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, email)
        }

        val intent = Intent(this, MainActivity::class.java).apply{
            putExtra(EXTRA_MESSAGE, User(firstName, lastName, email, password))
        }
        startActivity(intent)
    }
}