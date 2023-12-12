package com.example.ramon20101057ef2023

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ramon20101057ef2023.Adapter.ProductAdapter
import com.example.ramon20101057ef2023.model.ProductRepository

class ProductListActivity : AppCompatActivity() {

    private val productRepository by lazy { ProductRepository(this) }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        // Inserta un producto de ejemplo (puedes hacer esto en otro lugar según tus necesidades)
        val sampleProduct = Product(description = "Ejemplo", price = 10.99)
        productRepository.insertProduct(sampleProduct)

        // Obtiene la lista de productos y muestra en un RecyclerView
        val productList = productRepository.getAllProducts()

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ProductAdapter(productList)
    }

    private fun Product(description: String, price: Double) {

    }
}

private fun Unit.insertProduct(sampleProduct: Unit) {
    TODO("Not yet implemented")
}
