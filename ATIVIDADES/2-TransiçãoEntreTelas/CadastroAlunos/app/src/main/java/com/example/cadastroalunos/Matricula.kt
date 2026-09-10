package com.example.cadastroalunos

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Matricula : AppCompatActivity(R.layout.activity_matricula) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnMatricula = findViewById<Button>(R.id.btn_matricula)
        val txtnome = findViewById<TextView>(R.id.txt_nome)
        val txtmatricula = findViewById<TextView>(R.id.txt_matricula)
        val fltVoltar = findViewById<FloatingActionButton>(R.id.flt_voltar)

        val nomeAluno = intent.getStringExtra("nome_aluno")

        txtnome.text = "Nome: $nomeAluno"

        btnMatricula.setOnClickListener {
            val matriculaGerar = (100000..999999).random()
            txtmatricula.text = "Matrícula: $matriculaGerar"
        }

        fltVoltar.setOnClickListener {
            finish()
        }



    }
}

