package com.example.cadastroalunos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val edtNome = findViewById<EditText>(R.id.edt_nomeAluno)
        val btnenviar = findViewById<Button>(R.id.btn_enviar)
        val fltproximo = findViewById<FloatingActionButton>(R.id.flt_proximo)

        btnenviar.setOnClickListener {
            val nome = edtNome.text.toString()
            Toast.makeText(this,"Salvo Com Sucesso!",Toast.LENGTH_SHORT).show()
        }

        fltproximo.setOnClickListener {
            val intent = Intent(this, Matricula::class.java)
            intent.putExtra("nome_aluno", edtNome.text.toString())
            startActivity(intent)
        }
    }
}