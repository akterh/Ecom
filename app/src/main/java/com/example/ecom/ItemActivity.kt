package com.example.ecom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class ItemActivity : AppCompatActivity() {
    lateinit var item_rv:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        item_rv = findViewById(R.id.item_rv)

        val list = ArrayList<Items>()
        val item:String? =intent.getStringExtra("cat")
        val baseUrl = "http://192.168.0.103/salesweb/get_item.php?item_category_id=$item"


        val requestQueue = Volley.newRequestQueue(this)
        val jar = JsonArrayRequest(Request.Method.GET,baseUrl,null, { response ->

            for (x in 0 until response.length()){
                list.add(Items(response.getJSONObject(x).getInt("id"),response.getJSONObject(x).getString("name"),response.getJSONObject(x).getDouble("price"),response.getJSONObject(x).getString("image")))

                val adp = ItemAdapter(this,list)
                item_rv.layoutManager = LinearLayoutManager(this)
                item_rv.adapter = adp

            }

        },
            { error ->
                Toast.makeText(this,error.message,Toast.LENGTH_SHORT).show()

            })
        requestQueue.add(jar)

    }
}