package com.example.g10_hamburgueria

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import android.widget.Button
import android.widget.Toast
import com.example.g10_hamburgueria.repository.PerfilRepository
import kotlinx.parcelize.Parcelize

class DisplayInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_info)

        val perfil = PerfilRepository.getPerfil()

        if (perfil != null) {
            findViewById<TextView>(R.id.displayUsername).text = perfil.username
            findViewById<TextView>(R.id.displayPassword).text = perfil.password
            findViewById<TextView>(R.id.displayAddress).text = perfil.address
            findViewById<TextView>(R.id.displayPhoneNumber).text = perfil.phoneNumber
            findViewById<TextView>(R.id.displayEmail).text = perfil.email
            findViewById<TextView>(R.id.displayCardNumber).text = perfil.cardNumber
            findViewById<TextView>(R.id.displayCardBrand).text = perfil.cardBrand
            findViewById<TextView>(R.id.displayCardHolderName).text = perfil.cardHolderName
            findViewById<TextView>(R.id.displayCardExpiryDate).text = perfil.cardExpiryDate
            findViewById<TextView>(R.id.displayCardCVV).text = perfil.cardCVV

            findViewById<Button>(R.id.confirmButton).setOnClickListener {
                Toast.makeText(this, "Informações confirmadas", Toast.LENGTH_SHORT).show()
                finish()
            }
        } else {
            Toast.makeText(this, "Erro ao carregar informações", Toast.LENGTH_SHORT).show()
        }
    }
}
