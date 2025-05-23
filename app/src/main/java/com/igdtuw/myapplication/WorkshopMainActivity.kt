// WorkshopMainActivity.kt
package com.igdtuw.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.igdtuw.myapplication.ListAdapter1
import com.igdtuw.myapplication.WorkshopMainActivity2
import com.igdtuw.myapplication.databinding.ActivityWorkshopMainBinding

class WorkshopMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWorkshopMainBinding
    private lateinit var listAdapter: ListAdapter1
    private var dataArrayList = ArrayList<ListData1>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkshopMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageList = intArrayOf(
            R.drawable.sample_workshop_image,
            R.drawable.clayplay1,
            R.drawable.mm1,
            R.drawable.hh_image
        )

        val nameList = arrayOf(
            "Pottery Prodigy",
            "ClayPlay",
            "Mud & Mindfulness",
            "Heritage Hands"
        )

        val descList = arrayOf(
            "Date: 7th Nov\nTime: 4:00 p.m.\nPlace: Lodhi Garden",
            "Date: 10th Nov\nTime: 4:00 p.m.\nPlace: Lodhi Garden",
            "Date: 13th Nov\nTime: 4:00 p.m.\nPlace: VikasPuri",
            "Date: 16th Nov\nTime: 4:00 p.m.\nPlace: VikasPuri"
        )

        val priceList = arrayOf(
            "Price: Rs. 99.00",
            "Price: Rs. 149.00",
            "Price: Rs. 59.00",
            "Price: Rs. 199.00"
        )

        for (i in imageList.indices) {
            val listData = ListData1(imageList[i], nameList[i], descList[i], priceList[i])
            dataArrayList.add(listData)
        }

        listAdapter = ListAdapter1(this, dataArrayList)
        binding.listview.adapter = listAdapter

        binding.listview.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, WorkshopMainActivity2::class.java)
            intent.putExtra("workshopName", nameList[position])
            startActivity(intent)
        }
        binding.imageView2.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        binding.imageView3.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}
