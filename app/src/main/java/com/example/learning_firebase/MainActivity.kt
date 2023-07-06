package com.example.learning_firebase

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    lateinit var editTextName : EditText
    lateinit var buttonSend : Button

    val database : FirebaseDatabase = FirebaseDatabase.getInstance()
    val reference : DatabaseReference = database.reference.child("Users")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.editTextName)
        buttonSend = findViewById(R.id.buttonSend)

        buttonSend.setOnClickListener {
            val userName : String = editTextName.text.toString()

            reference.child("userName").setValue(userName)
        }
    }
}