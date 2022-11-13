package com.miu.a3walmart

import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ShoppingCategoryActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shopping_category_activity)

        val email = intent.getStringExtra(EXTRA_MESSAGE)

        findViewById<TextView>(R.id.welcome).setText("Welcome " + email)
    }

    fun showDescription(view: View) {
        Toast.makeText(this, "You have chosen the " + view.contentDescription + " category of shopping!", Toast.LENGTH_LONG).show()
    }
}