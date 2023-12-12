package com.example.ramon20101057ef2023.Adapter

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ramon20101057ef2023.Adapter.ProductAdapter.ProductViewHolder
import com.example.ramon20101057ef2023.R
import com.example.ramon20101057ef2023.model.Product

class ProductAdapter (private val productList: List<Product>) : RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(itemView)
    }

    class ProductViewHolder(itemView: Any) {
        fun bind(product: Product) {
            TODO("Not yet implemented")
        }

    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

}