package com.example.ecom

import android.content.Context

import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ItemAdapter(var context: Context,var list: ArrayList<Items>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view:View = LayoutInflater.from(context).inflate(R.layout.itemview,parent,false)
        return ItemHolder(view)

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
            Glide.with(context).downloadOnly().load("http://reofood.com.bd"+img).into(itemImg);

        }

    }

}






