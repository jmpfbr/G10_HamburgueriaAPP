package com.example.g10_hamburgueria.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.g10_hamburgueria.databinding.FoodItemBinding
import com.example.g10_hamburgueria.model.Food

class FoodAdapter(
    private val context: Context,
    private val foodList: MutableList<Food>,
    private val addCartListener: (Food) -> Unit
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val listItem = FoodItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return FoodViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.bind(food)
    }

    inner class FoodViewHolder(private val binding: FoodItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val imgFood = binding.imgFood
        val txtFoodName = binding.txtFoodName
        val txtFoodDescription = binding.txtFoodDescription
        val txtPrice = binding.txtPrice
        val btAddCart = binding.btAddCart

        fun bind(food: Food) {
            imgFood.setBackgroundResource(food.imgFood!!)
            txtFoodName.text = food.foodName
            txtFoodDescription.text = food.foodDescription
            txtPrice.text = food.price
            btAddCart.setOnClickListener {
                addCartListener(food)
            }
        }
    }
}
