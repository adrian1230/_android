package com.ifbooth.ifbooth_android

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_profile.*


class ProfileActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val logOut = LoggedLogOut

        auth = FirebaseAuth.getInstance()

        logOut.setOnClickListener {
            auth.signOut()
            finish()
//            val intentLogOut = Intent(this, LogInActivity::class.java)
//            startActivity(intentLogOut)
        }
    }

}