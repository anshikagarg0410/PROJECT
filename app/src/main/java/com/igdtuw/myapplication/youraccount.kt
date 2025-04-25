package com.igdtuw.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.igdtuw.myapplication.R

class youraccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youraccount)
        Log.d("DEBUG_SCREEN", "YourAccount activity launched")

        val backIcon = findViewById<ImageView>(R.id.backIcon)
        backIcon.setOnClickListener {
            val intent = Intent(this, sellpage::class.java)
            startActivity(intent)
        }
        val homeIcon = findViewById<ImageView>(R.id.homeIcon)
        homeIcon.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

}