package com.ifbooth.ifbooth_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LogInActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val logIn = logIN
        val signUp = newUserRegister

        auth = FirebaseAuth.getInstance()

        logIn.setOnClickListener {
            val accountLogin = accountForLogIn.text.trim().toString()
            val passwordLogIn = passwordForLogIn.text.trim().toString()

            if (accountLogin.isNotEmpty() || passwordLogIn.isNotEmpty()) {
                auth.signInWithEmailAndPassword(accountLogin,passwordLogIn)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            Log.d("Register","basic bitch")
                            var intentProfile = Intent(this,ProfileActivity::class.java)
                            startActivity(intentProfile)
                        } else {
                            Toast.makeText(this,"error: " + it.exception,Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this,"err",Toast.LENGTH_SHORT).show()
            }
        }

        signUp.setOnClickListener {
            val intentRegister = Intent(this, SignUpActivity::class.java)
            startActivity(intentRegister)
        }
    }
}