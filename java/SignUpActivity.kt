package com._android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_signup.*

class SignUpActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_signup)

        val gotAccount = GotAccount
        val register = Register

        auth = FirebaseAuth.getInstance()

        register.setOnClickListener {
            registerNewGuys()
        }

        gotAccount.setOnClickListener {
            var intentLogin = Intent(this,LogInActivity::class.java)
            startActivity(intentLogin)
        }
    }

    private fun registerNewGuys() {
        val userName = NewUserName.text.toString()
        val fullName = NewUserFullName.text.toString()
        val emailAddress = NewUserEmail.text.toString()
        val phone = NewUserPhone.text.toString()
        val password = NewUserPassword.text.toString()
        val confirmPassword = NewUserConfirmPassword.text.toString()

        if (emailAddress.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill in all the blank",Toast.LENGTH_SHORT).show()
            return
        }

        else {
            auth.createUserWithEmailAndPassword(emailAddress,password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        var intentHome = Intent(this,ProfileActivity::class.java)
                        startActivity(intentHome)
                    }
                }
                .addOnFailureListener {
                    Log.d("Main","failed: ${it.message}")
                    Toast.makeText(this, "failed: ${it.message}",Toast.LENGTH_SHORT).show()
                }
        }
    }
}
