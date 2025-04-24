package com.igdtuw.myapplication

import android.os.Bundle
import android.util.Patterns
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore
import com.igdtuw.myapplication.databinding.ActivityDetailedBinding

class DetailedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailedBinding
    private lateinit var db: FirebaseFirestore
    private lateinit var statusMessage: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedBinding.inflate(layoutInflater)
        statusMessage = findViewById(R.id.statusMessage)
        setContentView(binding.root)

        // Firestore instance
        db = FirebaseFirestore.getInstance()

        // Back arrow functionality
        binding.imageView3.setOnClickListener {
            finish()
        }

        // Get intent extras
        val image = intent.getIntExtra("InstructorImage", R.drawable.potter1)
        val title = intent.getStringExtra("courseTitle")
        val description = intent.getStringExtra("courseDescription")
        val instructorName = intent.getStringExtra("InstructorName")

        // Set data into views
        binding.imageView5.setImageResource(image)
        binding.courseTitle.text = title
        binding.courseDescription.text = description
        binding.textView12.text = "INSTRUCTOR NAME\n$instructorName"

        // Gender dropdown setup
        val genderOptions = listOf("Male", "Female", "Other")
        val genderAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            genderOptions
        )
        val genderDropdown = binding.autoCompleteTextView8
        genderDropdown.setAdapter(genderAdapter)
        genderDropdown.setOnClickListener {
            genderDropdown.showDropDown()
        }

        binding.payButton.setOnClickListener {
            val name = binding.editTextText3.text.toString().trim()
            val email = binding.editTextText4.text.toString().trim()
            val phone = binding.editTextPhone.text.toString().trim()
            val address = binding.editTextText8.text.toString().trim()
            val gender = genderDropdown.text.toString().trim()

            // Print user input to Logcat
            Log.d("RegisterDebug", "Clicked Pay - Name: $name, Email: $email, Phone: $phone, Address: $address, Gender: $gender")

            // Validation checks
            if (name.isEmpty()) {
                binding.editTextText3.error = "Name required"
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.editTextText4.error = "Invalid email"
                return@setOnClickListener
            }

            if (phone.isEmpty()) {
                binding.editTextPhone.error = "Phone number required"
                return@setOnClickListener
            }

            if (address.isEmpty()) {
                binding.editTextText8.error = "Address required"
                return@setOnClickListener
            }

            if (gender.isEmpty()) {
                genderDropdown.error = "Select gender"
                return@setOnClickListener
            }

            // Preparing data to save
            val userData = hashMapOf(
                "name" to name,
                "email" to email,
                "phone" to phone,
                "address" to address,
                "gender" to gender,
                "courseTitle" to title,
                "instructorName" to instructorName
            )

            Log.d("RegisterDebug", "Sending to Firestore: $userData")

            db.collection("registrations")
                .add(userData)
                .addOnSuccessListener {
                    Log.d("RegisterDebug", "Firestore save SUCCESS")
                    Toast.makeText(this, "You are registered!", Toast.LENGTH_LONG).show()
                    statusMessage.text = "✅ You are registered!"
                    clearForm()
                }
                .addOnFailureListener {
                    Log.e("RegisterDebug", "Firestore save FAILED: ${it.message}")
                    Toast.makeText(this, "Failed to register: ${it.message}", Toast.LENGTH_LONG).show()
                    statusMessage.text = "❌ Failed to register: ${it.message}"
                }

        }

        // Handle window insets for padding
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun clearForm() {
        binding.editTextText3.text.clear()
        binding.editTextText4.text.clear()
        binding.editTextPhone.text.clear()
        binding.editTextText8.text.clear()
        binding.autoCompleteTextView8.text.clear()
    }
}
