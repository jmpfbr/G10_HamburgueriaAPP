package com.example.g10_hamburgueria

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.g10_hamburgueria.adapter.FoodAdapter
import com.example.g10_hamburgueria.databinding.ActivityCarrinhoBinding
import com.example.g10_hamburgueria.model.Food

class Carrinho : AppCompatActivity() {

    private lateinit var binding: ActivityCarrinhoBinding
    private lateinit var foodAdapter: FoodAdapter
    private val foodList: MutableList<Food> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarrinhoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        getFood()

        binding.btnVoltar.setOnClickListener {
            val intent = Intent(this, Cardapio::class.java)
            startActivity(intent)
        }

        binding.btnPagar.setOnClickListener {
            val intent = Intent(this, Pagamento::class.java)
            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun setupRecyclerView() {
        val recyclerViewFood = binding.recyclerViewCarrinho
        recyclerViewFood.layoutManager = LinearLayoutManager(this)
        recyclerViewFood.setHasFixedSize(true)
        foodAdapter = FoodAdapter(this, foodList) { food ->
            addToCart(food)
        }
        recyclerViewFood.adapter = foodAdapter
    }

    private fun addToCart(food: Food) {
        foodList.add(food)
        foodAdapter.notifyDataSetChanged()
    }

    private fun getFood() {
        val food1 = Food(
            imgFood = R.drawable.hamburguer1,
            foodName = "X-Tudo Premium",
            foodDescription = "Hamburguer feito com uma carne + Refrigerante.",
            price = "R$ 10,00"
        )
        foodList.add(food1)
    }
}
