package com.example.dao

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dao.DAO.ImcDAO
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ImcActivity : AppCompatActivity(R.layout.activity_imc) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mostraImc = findViewById<TextView>(R.id.txt_imc)
        val mensagem = findViewById<TextView>(R.id.txt_mensagem)
        val voltar = findViewById<FloatingActionButton>(R.id.fab_volta)

        val imc = ImcDAO.buscar()
        val resultado = imc.calcularImc()
        mostraImc.text = "Seu IMC é: %.2f".format(resultado)

        mensagem.text = when {
            resultado < 18.5 -> "Abaixo do peso"
            resultado < 25.0 -> "Peso ideal"
            resultado < 30.0 -> "Sobrepeso"
            else -> "Obesidade"
        }

        voltar.setOnClickListener {
            finish()
        }

    }
}