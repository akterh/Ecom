package com.example.ecom.activities

import android.content.Intent

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.ecom.R
import com.example.ecom.Utils.Constants


class HomeActivity : AppCompatActivity() {
    lateinit var listView:ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        listView = findViewById(R.id.home_cat)

        val url = Constants()
        val webUrl = url.IP

        val baseUrl = "$webUrl/get_cat.php"


        val list = ArrayList<String>()
        val rq: RequestQueue = Volley.newRequestQueue(this)
        val jar = JsonArrayRequest(Request.Method.GET, baseUrl,null, { response ->
            for( x in 0 until response.length()){

                list.add(response.getJSONObject(x).getString("item_category_id"))

                val adp = ArrayAdapter(this, R.layout.mytextview,list)
                listView.adapter = adp
                Log.d("adapter","${listView.adapter}")

            }

        }, { error ->
            Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()

        })
        rq.add(jar)

        listView.setOnItemClickListener { parent, view, position, id ->

            val cat:String = list[position]
            val intent = Intent(this, ItemActivity::class.java)
            intent.putExtra("cat",cat)
            startActivity(intent)

        }
    }


}
