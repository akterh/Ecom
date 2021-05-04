package com.example.ecom.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.ecom.R
import com.example.ecom.Utils.Constants
import com.example.ecom.adapter.ItemAdapter
import com.example.ecom.model.Items

class ItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)


        val list = ArrayList<Items>()

        val item:String? =intent.getStringExtra("cat")

        val url = Constants()
        val webUrl = url.IP
        val baseUrl = "$webUrl/get_item.php?item_category_id=$item"


        val requestQueue = Volley.newRequestQueue(this)
        val jar = JsonArrayRequest(Request.Method.GET,baseUrl,null, { response ->


                for (x in 0 until response.length()){
                    list.add(Items(response.getJSONObject(x).getString("name"),response.getJSONObject(x).getDouble("price"),response.getJSONObject(x).getString("image")))

                    val adp = ItemAdapter(this,list)
                    var item_rv= findViewById<RecyclerView>(R.id.item_rv)
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