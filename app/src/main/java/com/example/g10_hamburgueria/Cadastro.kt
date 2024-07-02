package com.example.g10_hamburgueria

import android.annotation.SuppressLint
import android.os.Bundle
import android.content.Intent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.g10_hamburgueria.repository.PerfilRepository

class CadastroActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var addressEditText: EditText
    private lateinit var phoneNumberEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var cardNumberEditText: EditText
    private lateinit var cardBrandRadioGroup: RadioGroup
    private lateinit var cardHolderNameEditText: EditText
    private lateinit var cardExpiryDateEditText: EditText
    private lateinit var cardCVVEditText: EditText
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        addressEditText = findViewById(R.id.addressEditText)
        phoneNumberEditText = findViewById(R.id.phoneNumberEditText)
        emailEditText = findViewById(R.id.emailEditText)
        cardNumberEditText = findViewById(R.id.cardNumberEditText)
        cardBrandRadioGroup = findViewById(R.id.cardBrandRadioGroup)
        cardHolderNameEditText = findViewById(R.id.cardHolderNameEditText)
        cardExpiryDateEditText = findViewById(R.id.cardExpiryDateEditText)
        cardCVVEditText = findViewById(R.id.cardCVVEditText)
        registerButton = findViewById(R.id.registerButton)




        cardCVVEditText.filters = arrayOf(android.text.InputFilter.LengthFilter(3))

        cardExpiryDateEditText.addTextChangedListener(object : android.text.TextWatcher {
            override fun afterTextChanged(s: android.text.Editable?) {
                if (s?.length == 2 && !s.contains("/")) {
                    val month = s.substring(0, 2)
                    val formatted = "$month/"
                    cardExpiryDateEditText.setText(formatted)
                    cardExpiryDateEditText.setSelection(formatted.length)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Não utilizado
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Não utilizado
            }
        })

        registerButton.setOnClickListener {
            val perfil = getInfo()
            if (perfil == null) {
                Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            PerfilRepository.setPerfil(perfil)

            val intent = Intent(this, DisplayInfoActivity::class.java)
            startActivity(intent)
            finish()
        }

        registerButton.setOnLongClickListener {
            runOnUiThread {
                usernameEditText.setText("user")
                passwordEditText.setText("senha")
                addressEditText.setText("Avenida Maracanã, 1902, Rio de Janeiro")
                phoneNumberEditText.setText("21 96123-4567")
                emailEditText.setText("user@email.com")
                cardNumberEditText.setText("1234567890")
                cardHolderNameEditText.setText("User da Silva")
                cardExpiryDateEditText.setText("25/06")
                cardCVVEditText.setText("123")
            }
            true
        }
    }

    private fun getInfo(): Perfil? {

        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()
        val address = addressEditText.text.toString()
        val phoneNumber = phoneNumberEditText.text.toString()
        val email = emailEditText.text.toString()
        val cardNumber = cardNumberEditText.text.toString()
        val cardBrand = when (cardBrandRadioGroup.checkedRadioButtonId) {
            R.id.visaRadioButton -> "Visa"
            R.id.mastercardRadioButton -> "MasterCard"
            R.id.amexRadioButton -> "Amex"
            else -> ""
        }
        val cardHolderName = cardHolderNameEditText.text.toString()
        val cardExpiryDate = cardExpiryDateEditText.text.toString()
        val cardCVV = cardCVVEditText.text.toString()

        return if (username.isNotEmpty() && password.isNotEmpty() && address.isNotEmpty() && phoneNumber.isNotEmpty() && email.isNotEmpty() &&
            cardNumber.isNotEmpty() && cardBrand.isNotEmpty() && cardHolderName.isNotEmpty() &&
            cardExpiryDate.isNotEmpty() && cardCVV.isNotEmpty()
        ) {
            Perfil(
                username,
                password,
                address,
                phoneNumber,
                email,
                cardNumber,
                cardBrand,
                cardHolderName,
                cardExpiryDate,
                cardCVV
            )
        } else {
            null
        }
    }
}
