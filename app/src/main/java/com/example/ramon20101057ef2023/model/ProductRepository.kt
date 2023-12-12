package com.example.ramon20101057ef2023.model

import android.content.ContentValues
import android.content.Context
import android.database.Cursor

class ProductRepository (context: Context) {

    private val dbHelper = ProductDbHelper(context)

    fun insertProduct(product: Unit): Long {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(ProductContract.COLUMN_NAME, product.name)
            put(ProductContract.COLUMN_PRICE, product.price)
        }
        return db.insert(ProductContract.TABLE_NAME, null, values)
    }

    fun getAllProducts(): List<Product> {
        val db = dbHelper.readableDatabase
        val projection = arrayOf(
            ProductContract.COLUMN_ID,
            ProductContract.COLUMN_NAME,
            ProductContract.COLUMN_PRICE
        )

        val cursor: Cursor = db.query(
            ProductContract.TABLE_NAME,
            projection,
            null,
            null,
            null,
            null,
            null
        )

        val productList = mutableListOf<Product>()
        while (cursor.moveToNext()) {
            val productId = cursor.getLong(cursor.getColumnIndexOrThrow(ProductContract.COLUMN_ID))
            val productName = cursor.getString(cursor.getColumnIndexOrThrow(ProductContract.COLUMN_NAME))
            val productPrice = cursor.getDouble(cursor.getColumnIndexOrThrow(ProductContract.COLUMN_PRICE))
            val product = Product(productId, productName, productPrice)
            productList.add(product)
        }
        cursor.close()
        return productList
    }

    private fun Product(id: Long, description: String?, quantity: Double) {

    }
}