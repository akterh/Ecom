package com.example.ecom.activities

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
import com.example.ecom.R
import com.example.ecom.Utils.Constants
import com.example.ecom.model.UsersInfo

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
            if (pass == passCon) {

                val url = Constants()
                val webUrl = url.IP
                val baseUrl =
                    "$webUrl/add_user.php?mobile=$mobile&pass=$pass&" +
                            "name=$name&add=$add"
                val rq:RequestQueue = Volley.newRequestQueue(this)
                val stringRequest = StringRequest(Request.Method.GET,baseUrl, { response ->
                    if (response.equals("1")){
                        UsersInfo.mobile = mobile
                    val i = Intent(this, HomeActivity::class.java)
                    startActivity(i)

                }else
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
