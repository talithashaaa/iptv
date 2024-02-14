package com.example.tvapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class OrderFood : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_food)
        supportActionBar?.hide()

    }
}