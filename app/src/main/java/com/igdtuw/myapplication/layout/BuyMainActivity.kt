package com.igdtuw.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.igdtuw.myapplication.databinding.ActivityBuyMainBinding
import com.igdtuw.myapplication.databinding.ActivityMainBinding

class BuyMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBuyMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuyMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Use the root view from ViewBinding
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.Gift.setOnClickListener {
            startActivity(Intent(this, GiftActivity::class.java))
        }
        binding.trending.setOnClickListener {
            startActivity(Intent(this, TrendingActivity::class.java))
        }
        binding.premade.setOnClickListener {
            startActivity(Intent(this, PremadeActivity::class.java))
        }
        binding.personalized.setOnClickListener {
            startActivity(Intent(this, PersonalizedActivity::class.java))
        }
        binding.imageView6.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
        binding.imageView7.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

    }
}
