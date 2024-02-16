package com.example.tvapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.TextView
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone

class RoomServiceDescription : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_service_description)

        supportActionBar?.hide()
        val calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Jakarta"))
        val dateFormat = DateFormat.getDateInstance().format(calendar.time)

        val dateTextView = findViewById<TextView>(R.id.text_date)
        dateTextView.text = dateFormat

        val dayFormat = SimpleDateFormat("EEEE", Locale.ENGLISH)
        val dayTextView = findViewById<TextView>(R.id.text_day)
        val dayOfWeek = dayFormat.format(calendar.time)
        dayTextView.text = dayOfWeek

        val serviceButton = findViewById<Button>(R.id.serviceButton)
        serviceButton.setOnClickListener {
            val intent = Intent(this, RoomServiceDetail::class.java)
            startActivity(intent)
        }
    }

    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        if (event.action == KeyEvent.ACTION_DOWN) {
            when (event.keyCode) {
                KeyEvent.KEYCODE_DPAD_DOWN, KeyEvent.KEYCODE_DPAD_UP,
                KeyEvent.KEYCODE_DPAD_LEFT, KeyEvent.KEYCODE_DPAD_RIGHT -> {
                    val serviceButton = findViewById<Button>(R.id.serviceButton)
                    serviceButton.requestFocus()
                    serviceButton.scaleX = 1.2f
                    serviceButton.scaleY = 1.2f
                    return true
                }
                KeyEvent.KEYCODE_ENTER -> {
                    if (currentFocus == findViewById<Button>(R.id.serviceButton)) {
                        navigateToServiceDetail()
                        return true
                    }
                }
            }
        }
        return super.dispatchKeyEvent(event)
    }
    private fun navigateToServiceDetail() {
        val intent = Intent(this, RoomServiceDetail::class.java)
        startActivity(intent)
    }

}