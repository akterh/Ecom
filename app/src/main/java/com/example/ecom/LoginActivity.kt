package com.example.ecom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class LoginActivity : AppCompatActivity() {


    lateinit var register:Button
    lateinit var login:Button
    lateinit var mobile :EditText
    lateinit var password:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        register = findViewById(R.id.btn_reg)
        login = findViewById(R.id.btn_login)
        mobile = findViewById(R.id.edt_mob)
        password = findViewById(R.id.edt_pass)
        register.setOnClickListener {
            var i = Intent(this,RegisterActivity::class.java)
            startActivity(i)
        }
        login.setOnClickListener {
            val logMobile =mobile.text.toString()
            val logPass = password.text.toString()

            val baseUrl =
                "http://192.168.0.103/salesweb/login.php?mobile=$logMobile&password=$logPass"
            val rq: RequestQueue = Volley.newRequestQueue(this)
            val stringRequest = StringRequest(Request.Method.GET,baseUrl, { response ->
                if (response.equals("available")) {
                    UsersInfo.mobile = logMobile
                    val i = Intent(this, HomeActivity::class.java)
                    startActivity(i)

                }else
                    Toast.makeText(this,"UserName or password error", Toast.LENGTH_LONG).show()


            }, { error->
                Toast.makeText(this,error.message, Toast.LENGTH_SHORT).show()


            })
            rq.add(stringRequest)


        }




    }
}