package com.example.rgbapp

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.rgbapp.R
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // what happens when you click the enter button
        findViewById<Button>(R.id.createRGB_button)?.setOnClickListener {
            // get created rgb display
            val createdRGBDisplay = findViewById<TextView>(R.id.createdRGB_display)
            // get the colors TextInputEditText values and trim them
            val redChannel = findViewById<TextInputEditText>(R.id.red_channel)?.text.toString().trim()
            val greenChannel = findViewById<TextInputEditText>(R.id.green_channel).text.toString().trim()
            val blueChannel = findViewById<TextInputEditText>(R.id.blue_channel).text.toString().trim()

            // check that the input fields are not empty
            if (redChannel.isNotEmpty() && greenChannel.isNotEmpty() && blueChannel.isNotEmpty()) {
                // combine the values to a hex code string
                val hexColor = "#$redChannel$greenChannel$blueChannel"
                // parse the hex code to int because setBackgroundColor only accepts integers
                val intColor = Color.parseColor(hexColor)
                // show the 'created color display' text
                createdRGBDisplay?.text = "${getString(R.string.created_color_display)} $hexColor"
                // set the background color
                createdRGBDisplay.setBackgroundColor(intColor)
            }
            // show floating error message if no values input
            else {
                Toast.makeText(this, getString(R.string.please_input_correctly), Toast.LENGTH_LONG).apply {
                    setGravity(Gravity.CENTER, 0, 0)
                    show()
                }
            }
        }
    }
}
// strings.xml -> themes.xml -> activity_main.xml -> mainActivity.kt   DONE