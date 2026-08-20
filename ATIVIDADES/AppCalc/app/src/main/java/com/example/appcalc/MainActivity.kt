package com.example.appcalc

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button

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
        val edtValor1 = findViewById<EditText>(R.id.edt_valor1)
        val edtValor2 = findViewById<EditText>(R.id.edt_valor2)
        val btnsoma = findViewById<Button>(R.id.btn_soma)
        val btnsubtracao = findViewById<Button>(R.id.btn_subtracao)
        val btnmultiplicacao = findViewById<Button>(R.id.btn_multiplicacao)
        val btndivisao = findViewById<Button>(R.id.btn_divisao)
        val txvResultado = findViewById<TextView>(R.id.txt_resultado)

        btnsoma.setOnClickListener {
            val valor1 = edtValor1.text.toString().toDouble()
            val valor2 = edtValor2.text.toString().toDouble()
            val soma = valor1+valor2
            txvResultado.setText("A Soma é: $soma")
            edtValor1.text.clear()
            edtValor2.text.clear()

            Toast.makeText(this,"Calculo Realizado!", Toast.LENGTH_SHORT).show()

        }

        btnsubtracao.setOnClickListener {
            val valor1 = edtValor1.text.toString().toDouble()
            val valor2 = edtValor2.text.toString().toDouble()
            val resultado = valor1-valor2
            txvResultado.setText("A Subtração é: $resultado")
            edtValor1.text.clear()
            edtValor2.text.clear()

            Toast.makeText(this,"Calculo Realizado!", Toast.LENGTH_SHORT).show()
        }

        btnmultiplicacao.setOnClickListener {
            val valor1 = edtValor1.text.toString().toDouble()
            val valor2 = edtValor2.text.toString().toDouble()
            val resultado = valor1 * valor2
            txvResultado.setText("A multiplicação é: $resultado")
            edtValor1.text.clear()
            edtValor2.text.clear()
        }

        btndivisao.setOnClickListener {
            val valor1 = edtValor1.text.toString().toDouble()
            val valor2 = edtValor2.text.toString().toDouble()
            val resultado = valor1 / valor2
            txvResultado.setText("A divisão é: $resultado")
            edtValor1.text.clear()
            edtValor2.text.clear()
        }
    }
}