package com.igdtuw.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class loginActivity : AppCompatActivity() {
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val Login = findViewById<Button>(R.id.btnLogin)
        val username= findViewById<TextInputEditText>(R.id.UserNameEditText)
        val password= findViewById<TextInputEditText>(R.id.PassowrdEditText)
        Login.setOnClickListener{
            val userNameString= username.text.toString()
            val passwordString= password.text.toString()
            if(userNameString.isNotEmpty() && passwordString.isNotEmpty()){
                readData(userNameString,passwordString)
            }else{
                Toast.makeText(this,  "Please enter Username and Password",Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun readData(userNameString: String, passwordString:String){
        databaseReference= FirebaseDatabase.getInstance().getReference("Users")
        databaseReference.child(userNameString).get().addOnSuccessListener {
            if(it.exists()){

                val password= it.child("password").value
                if(passwordString==password){
                    val intentWelcome=Intent(this@loginActivity, HomeActivity::class.java)
                    startActivity(intentWelcome)
                }else{
                    Toast.makeText(this,"Wrong password", Toast.LENGTH_SHORT).show()
                }

            }else{
                Toast.makeText(this, "User doesn't exists, please sign up",Toast.LENGTH_SHORT).show()
                val intentSignUp= Intent(this, signUpActivity::class.java)
                startActivity(intentSignUp)
            }
        }.addOnFailureListener{
            Toast.makeText(this, "Failed",Toast.LENGTH_SHORT).show()
        }
    }
}