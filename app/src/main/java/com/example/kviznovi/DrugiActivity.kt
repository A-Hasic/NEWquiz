package com.example.kviznovi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity



class DrugiActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sec)
        val button:  Button = findViewById(R.id.vrati_nazad)
        val butto: Button = findViewById(R.id.naprije)

        button.setOnClickListener {
            finish()
        }

        butto.setOnClickListener {
            val intent = Intent(this, TreciActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

