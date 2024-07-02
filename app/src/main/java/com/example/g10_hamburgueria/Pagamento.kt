package com.example.g10_hamburgueria

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.g10_hamburgueria.databinding.ActivityPagamentoBinding

class Pagamento : AppCompatActivity() {

    private lateinit var binding: ActivityPagamentoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPagamentoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()

        binding.btnDebito.setOnClickListener {
            Toast.makeText(this, "A opção Débito do cartão registrado foi selecionada.", Toast.LENGTH_SHORT).show()
        }

        binding.btnCredito.setOnClickListener {
            Toast.makeText(this, "A opção Crédito do cartão registrado foi selecionada.", Toast.LENGTH_SHORT).show()
        }

        binding.btnCash.setOnClickListener {
            Toast.makeText(this, "A opção Dinheiro foi selecionada, pague na entrega.", Toast.LENGTH_SHORT).show()
        }

        binding.btnPagar.setOnClickListener {
            val intent = Intent(this, Pedido::class.java)
            startActivity(intent)
        }
    }

    private fun setupToolbar() {
        val toolbar: Toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.title = "G10 Burguers"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        toolbar.setTitleTextColor(getColor(R.color.white))
        toolbar.navigationIcon?.setTint(getColor(R.color.white))

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}
