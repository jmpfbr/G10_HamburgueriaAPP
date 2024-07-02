package com.example.g10_hamburgueria

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonLogin = findViewById<Button>(R.id.button_login)
        val buttonUs = findViewById<Button>(R.id.button_us)

        buttonLogin.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        buttonUs.setOnClickListener {
            val intent = Intent(this, Sobrenos::class.java)
            startActivity(intent)
        }
    }
}
