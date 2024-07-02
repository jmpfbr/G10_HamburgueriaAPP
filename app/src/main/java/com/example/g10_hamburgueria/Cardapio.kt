package com.example.g10_hamburgueria

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.g10_hamburgueria.adapter.FoodAdapter
import com.example.g10_hamburgueria.databinding.ActivityCardapioBinding
import com.example.g10_hamburgueria.model.Food

class Cardapio : AppCompatActivity() {

    private lateinit var binding: ActivityCardapioBinding
    private lateinit var foodAdapter: FoodAdapter
    private val foodList: MutableList<Food> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardapioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupRecyclerView()
        getFood()
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


    private fun setupRecyclerView() {
        val recyclerViewFood = binding.RecyclerViewFood
        recyclerViewFood.layoutManager = LinearLayoutManager(this)
        recyclerViewFood.setHasFixedSize(true)
        foodAdapter = FoodAdapter(this, foodList) { food ->
            addToCart(food)
        }
        recyclerViewFood.adapter = foodAdapter
    }

    private fun addToCart(food: Food) {
        when (food) {
            foodList[0] -> { // food1
                val intent = Intent(this, Carrinho::class.java)
                startActivity(intent)
            }
            foodList[1], foodList[2], foodList[3], foodList[4] -> { // food2, food4, food5
                showOutOfStockDialog()
            }
        }
    }

    private fun showOutOfStockDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Fora de Estoque")
        builder.setMessage("Este item está temporariamente fora de estoque.")
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getFood() {
        val food1 = Food(
            imgFood = R.drawable.hamburguer1,
            foodName = "X-Tudo Premium",
            foodDescription = "Hamburguer feito com uma carne + Refrigerante.",
            price = "R$ 10,00"
        )
        foodList.add(food1)

        val food2 = Food(
            imgFood = R.drawable.hamburguer2,
            foodName = "X-Tudo Duplo Premium",
            foodDescription = "Hamburguer Duplo feito com duas carnes + Refrigerante.",
            price = "R$ 20,00"
        )
        foodList.add(food2)

        val food3 = Food(
            imgFood = R.drawable.hamburguer3,
            foodName = "X-G10",
            foodDescription = "Hamburguer Quádruplo Premium, feito com nossos ingredientes de mais alta qualidade e molho da casa + Refrigerante.",
            price = "R$ 30,00"
        )
        foodList.add(food3)

        val food4 = Food(
            imgFood = R.drawable.hamburguer4,
            foodName = "X-Chicken",
            foodDescription = "Hamburguer feito com peito de frango enpanado + Refrigerante.",
            price = "R$ 40,00"
        )
        foodList.add(food4)

        val food5 = Food(
            imgFood = R.drawable.hamburguer5,
            foodName = "X-Fish",
            foodDescription = "Hamburguer feito com carne de peixe enpanado + Refrigerante.",
            price = "R$ 50,00"
        )
        foodList.add(food5)

        foodAdapter.notifyDataSetChanged()
    }
}
