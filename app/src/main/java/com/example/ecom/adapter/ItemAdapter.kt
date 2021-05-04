package com.example.ecom.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ecom.Utils.Constants
import com.example.ecom.model.Items
import com.example.ecom.R
import com.squareup.picasso.Picasso

//class ItemAdapter(var list: ArrayList<Items>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        val view:View = LayoutInflater.inflate(R.layout.itemview,parent,false)
//        return ItemHolder(view)
//
//    }

class ItemAdapter( var context:Context,var list: ArrayList<Items> ): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var myView = LayoutInflater.from(context).inflate(R.layout.itemview,parent,false)
        return ItemHolder(myView)
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemHolder).itemBind(list[position].name,list[position].price,list[position].image)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ItemHolder(itemView: View):RecyclerView.ViewHolder(itemView){


        private var itemName = itemView.findViewById<TextView>(R.id.item_name)
        private var itemPrice = itemView.findViewById<TextView>(R.id.item_price)
        private var itemImg = itemView.findViewById<ImageView>(R.id.item_image)
        fun itemBind(name:String,price:Double,img:String){

            itemName.text = name
            itemPrice.text = price.toString()
            val url = Constants()
            val webUrl = url.IP
            Picasso.get().load("https://reofood.com.bd$img").into(itemImg);
            Log.d("img",img)



//            val builder =Picasso.Builder()
//            builder.listener(fun(picasso: Picasso, uri: Uri, exception: Exception) {
//                exception.printStackTrace()
//            })
//            builder.build().load("https://192.168.0.101/salesweb"+img).into(itemImg)


        }

    }

}






