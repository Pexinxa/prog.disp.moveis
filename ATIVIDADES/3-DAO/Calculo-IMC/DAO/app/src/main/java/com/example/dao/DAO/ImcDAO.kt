package com.example.dao.DAO

import com.example.dao.DAO.ImcDAO.Companion.meuImc
import com.example.dao.Model.Imc

class ImcDAO {

    companion object {

        private var meuImc = Imc()

        fun salvar(peso: Double, altura: Double): String {
            meuImc = Imc(peso, altura)
            return  "Salvando"
        }

        fun buscar(): Imc {
            return meuImc
        }

    }
}