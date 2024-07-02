package com.example.g10_hamburgueria

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class Sobrenos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sobre_nos)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "G10 Burguers"

        toolbar.setTitleTextColor(getColor(R.color.white))
        toolbar.navigationIcon?.setTint(getColor(R.color.white))
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
