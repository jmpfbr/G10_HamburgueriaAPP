package com.example.g10_hamburgueria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


class Menu : AppCompatActivity() {
    val itemId: Any
        get() {
            TODO()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)


        val btnVoltar = findViewById<View>(R.id.btnVoltar)
        btnVoltar.setOnClickListener {
            val intent = Intent(this@Menu, Login::class.java)
            startActivity(intent)
        }


        val btnCardapio = findViewById<View>(R.id.btnCardapio)
        btnCardapio.setOnClickListener {
            val intent = Intent(this@Menu, Cardapio::class.java)
            startActivity(intent)
        }

        val btnHistorico = findViewById<View>(R.id.btnCarrinho)
        btnHistorico.setOnClickListener {
            val intent = Intent(this@Menu, Historico::class.java)
            startActivity(intent)
        }
    }
}