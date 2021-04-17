package com.example.ecom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class RegisterActivity : AppCompatActivity() {
    lateinit var regMob:EditText
    lateinit var regPass:EditText
    lateinit var regConPass:EditText
    lateinit var regName:EditText
    lateinit var regAdd:EditText
    lateinit var submit:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        viewInit()
        submit.setOnClickListener {
            val mobile = regMob.text.toString()
            val pass = regPass.text.toString()
            val passCon = regConPass.text.toString()
            val name = regName.text.toString()
            val add = regAdd.text.toString()
            if (pass.equals(passCon)) {
                val baseUrl =
                    "http://192.168.0.101/salesWeb/add_user.php?mobile=$mobile&password=$pass&" +
                            "name=$name&address=$add"
                val rq:RequestQueue = Volley.newRequestQueue(this)
                val stringRequest = StringRequest(Request.Method.GET,baseUrl, { response ->
                if (response.equals("1"))
                    Toast.makeText(this,"User Created",Toast.LENGTH_LONG).show()
                else
                    Toast.makeText(this,"mobile already used",Toast.LENGTH_LONG).show()


                }, { error->
                    Toast.makeText(this,error.message,Toast.LENGTH_SHORT).show()


                })
                rq.add(stringRequest)
            }else{
                Toast.makeText(this,"Password doesn't match",Toast.LENGTH_LONG).show()
            }


        }


    }


    fun viewInit(){
        regMob = findViewById(R.id.edt_reg_mob)
        regPass = findViewById(R.id.edt_reg_pass)
        regConPass = findViewById(R.id.edt_reg_confirm_pass)
        regName = findViewById(R.id.edt_name)
        regAdd = findViewById(R.id.edt_address)
        submit = findViewById(R.id.btn_submit)
    }



}
