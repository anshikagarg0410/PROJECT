package com.igdtuw.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.igdtuw.myapplication.databinding.ActivityGiftBinding

class GiftActivity : AppCompatActivity() {

    private lateinit var addtocartbtn: Button
    private lateinit var secondcartbtn: Button
    private lateinit var binding: ActivityGiftBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityGiftBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addtocartbtn = findViewById(R.id.addToCartBtn1)
        secondcartbtn = findViewById(R.id.addToCartBtn2)

        binding.addToCartBtn1.setOnClickListener {
            Toast.makeText(this, "Added in cart!!", Toast.LENGTH_SHORT).show()
        }

        binding.addToCartBtn2.setOnClickListener {
            Toast.makeText(this, "Added in cart!!", Toast.LENGTH_SHORT).show()
        }


        binding.arrowBtn.setOnClickListener {
            startActivity(Intent(this, BuyMainActivity::class.java))
        }
        binding.homeBtn.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }

}