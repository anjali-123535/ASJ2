package com.example.asj2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val name =intent.getStringExtra("name")
        val roll=intent.getIntExtra("roll",0)
        val t_name:TextView=findViewById(R.id.name)
        val t_roll:TextView=findViewById(R.id.roll)
        t_name.text="Name: "+name
        t_roll.text="Roll: "+roll.toString()

    }
}