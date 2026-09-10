package com.example.dao.View

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dao.DAO.ImcDAO
import com.example.dao.ImcActivity
import com.example.dao.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.jvm.java

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val peso = findViewById<EditText>(R.id.edt_peso)
        val altura = findViewById<EditText>(R.id.edt_altura)
        val calcular = findViewById<Button>(R.id.btn_calcular)
        val avancar = findViewById<FloatingActionButton>(R.id.fab_avanca)

        calcular.setOnClickListener {
            val pesoPessoa = peso.text.toString().toDouble()
            val alturaPessoa = altura.text.toString().toDouble()
            val retorno = ImcDAO.salvar(pesoPessoa, alturaPessoa)
            Log.i("ESTADO",retorno)
            Toast.makeText(this, retorno, Toast.LENGTH_SHORT).show()
            peso.text.clear()
            altura.text.clear()
        }

        avancar.setOnClickListener {
            val intent = Intent(this, ImcActivity::class.java)
            startActivity(intent)
        }

    }
}