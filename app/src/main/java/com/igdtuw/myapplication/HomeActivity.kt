package com.igdtuw.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.LinearLayout

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val courseLayout = findViewById<LinearLayout>(R.id.coursesLayout)
        courseLayout.setOnClickListener {
            val intent = Intent(this, CourseMainActivity2::class.java)
            startActivity(intent)
        }
        val workshopLayout = findViewById<LinearLayout>(R.id.workshopsLayout)
        workshopLayout.setOnClickListener {
            val intent = Intent(this, WorkshopMainActivity::class.java)
            startActivity(intent)
        }

        val shopsnearbyLayout = findViewById<LinearLayout>(R.id.shopsnearbyLayout)
        shopsnearbyLayout.setOnClickListener {
            val intent = Intent(this, ShopsnearActivity::class.java)
            startActivity(intent)
        }

        val buyLayout = findViewById<LinearLayout>(R.id.buyLayout)
        buyLayout.setOnClickListener {
            val intent = Intent(this, BuyMainActivity::class.java)
            startActivity(intent)
        }

        val sellLayout = findViewById<LinearLayout>(R.id.sellLayout)
        sellLayout.setOnClickListener {
            val intent = Intent(this, sellpage::class.java)
            startActivity(intent)
        }

        val collabsLayout = findViewById<LinearLayout>(R.id.collabsLayout)
        collabsLayout.setOnClickListener {
            val intent = Intent(this, yourcollabs::class.java)
            startActivity(intent)
        }


    }
}