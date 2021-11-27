package com.example.daifratellikatalog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val mList: List<ItemsViewModel>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsViewModel = mList[position]

        //holder.textView.text = itemsViewModel.text
        holder.initialize(mList[position])

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val wineName: TextView = itemView.findViewById(R.id.wine_name)
        val winePrice: TextView = itemView.findViewById(R.id.wine_price)
        val wineImg: ImageView = itemView.findViewById(R.id.image)

        fun initialize(product: ItemsViewModel) {

            wineName.text = product.wineName
            winePrice.text = product.winePrice
            wineImg.setImageResource(product.imageId)

        }


    }

    interface onClick {

        fun onItemClick(operation: ItemsViewModel, position: Int) {

        }
    }


}
