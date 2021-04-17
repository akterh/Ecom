package com.example.ecom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {


    lateinit var register:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        register = findViewById(R.id.btn_reg)
        register.setOnClickListener {
            var i = Intent(this,RegisterActivity::class.java)
            startActivity(i)
        }
    }
}