package com.miu.a3walmart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.view.View
import android.widget.EditText
import android.widget.Toast

class ActivityForgotPassword : AppCompatActivity() {

    var users: ArrayList<User>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        users = intent.getSerializableExtra(AlarmClock.EXTRA_MESSAGE) as? ArrayList<User>
    }

    fun resetUserPassword() {
        val email: String = findViewById<EditText>(R.id.forgot_email_address).text.toString()
        var userFound: User? = null

        users?.forEach { user ->
            if(user._username.equals(email)) {
                userFound = user
            }
        }

        if(userFound != null) {
            val subject: String = "Password reset"
            val message: String = "Your password is: " + userFound!!._password

            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL, email)
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent, "Select email"))
        } else {
            Toast.makeText(this, "No account associated with ${email}", Toast.LENGTH_LONG).show()
        }
    }
}