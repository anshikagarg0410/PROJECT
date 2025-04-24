package com.igdtuw.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class sellpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sellpage)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val navigateTextView = findViewById<TextView>(R.id.navigatetoyourorders)
        navigateTextView.setOnClickListener {
            val intent = Intent(this, yourorders::class.java)
            startActivity(intent)
        }

        val accountTextView = findViewById<TextView>(R.id.navigatetoyouraccount)
        accountTextView.setOnClickListener {
            val intent = Intent(this, youraccount::class.java)
            startActivity(intent)
        }

        val collabLayout = findViewById<LinearLayout>(R.id.collabbutton)
        collabLayout.setOnClickListener {
            val intent = Intent(this, yourcollabs::class.java)
            startActivity(intent)
        }






    }
}