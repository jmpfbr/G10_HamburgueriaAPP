package com.example.g10_hamburgueria

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.g10_hamburgueria.databinding.ActivityHistoricoBinding

class Historico : AppCompatActivity() {

    private lateinit var binding: ActivityHistoricoBinding
    private lateinit var adapter: PedidoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoricoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()

        adapter = PedidoAdapter(getPedidos())
        binding.recyclerViewPedidos.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewPedidos.adapter = adapter
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

    private fun getPedidos(): List<Order> {
        return listOf(
            Order("Pedido 1", "Hoje", "R$10.00")
        )
    }
}
