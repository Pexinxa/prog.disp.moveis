package com.example.appconvtemp

import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val adcValor = findViewById<EditText>(R.id.adc_valor)
        val btnResultado = findViewById<Button>(R.id.btn_resultado)
        val txtResultado = findViewById<TextView>(R.id.txt_resultado)

        btnResultado.setOnClickListener {

            val valorDigitado = adcValor.text.toString()

            if (valorDigitado.isEmpty()) {

                Toast.makeText(
                    this,
                    "Digite uma temperatura!",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                val celsius = valorDigitado.toDouble()

                val fahrenheit = (celsius * 9 / 5) + 32

                txtResultado.text = "$celsius °C = $fahrenheit °F"

                adcValor.text.clear()

                Toast.makeText(
                    this,
                    "Conversão realizada!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }
}