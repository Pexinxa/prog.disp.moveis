package com.example.appcalculoprileiohm

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        val edtensao = findViewById<EditText>(R.id.ed_tensao)
        val edresistencia = findViewById<EditText>(R.id.ed_resistencia)
        val edcorrente = findViewById<EditText>(R.id.ed_corrente)
        val button = findViewById<Button>(R.id.btn_calcular)
        val txtresultado = findViewById<TextView>(R.id.txt_resultado)

        button.setOnClickListener {

            val tensao = edtensao.text.toString()
            val resistencia = edresistencia.text.toString()
            val corrente = edcorrente.text.toString()

            // Tensão e resistência preenchidas → calcula corrente
            if (tensao.isNotEmpty() && resistencia.isNotEmpty() && corrente.isEmpty()) {

                val t = tensao.toDouble()
                val r = resistencia.toDouble()

                val resultado = t / r

                txtresultado.text = "Corrente: $resultado A"
            }

            else if (tensao.isNotEmpty() && corrente.isNotEmpty() && resistencia.isEmpty()) {

                val t = tensao.toDouble()
                val i = corrente.toDouble()

                val resultado = t / i

                txtresultado.text = "Resistência: $resultado Ω"
            }

            else if (resistencia.isNotEmpty() && corrente.isNotEmpty() && tensao.isEmpty()) {

                val r = resistencia.toDouble()
                val c = corrente.toDouble()

                val resultado = r * c

                txtresultado.text = "Tensão: $resultado V"
            }

            else {
                Toast.makeText(
                    this,
                    "Preencha exatamente dois campos!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}