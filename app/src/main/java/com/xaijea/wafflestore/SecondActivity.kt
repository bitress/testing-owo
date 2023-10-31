package com.xaijea.wafflestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val flavorTextView = findViewById<TextView>(R.id.flavorTextView)
        val sizeTextView = findViewById<TextView>(R.id.sizeTextView)
        val toppingsTextView = findViewById<TextView>(R.id.toppingsTextView)
        val totalPriceTextView = findViewById<TextView>(R.id.totalPriceTextView)

        // Retrieve data from the intent
        val flavor = intent.getStringExtra("flavour")
        val size = intent.getStringExtra("size")
        val toppings = intent.getStringArrayListExtra("toppings")
        val totalPrice = intent.getIntExtra("totalPrice", 0)

        // Display the retrieved data in the TextViews
        flavorTextView.text = "Flavor: $flavor"
        sizeTextView.text = "Size: $size"
        toppingsTextView.text = "Toppings: ${toppings?.joinToString(", ")}"
        totalPriceTextView.text = "Total Price: $totalPrice"
    }
}
