package com.example.medicamentos

import android.content.ContentValues

data class Medicamentos(var nome: String, var idCategoria: Long, var isbn: String? = null, var id: Long= -1) {
    fun toContentValues() : ContentValues{
        val valores = ContentValues()

        valores.put(TabelaMedicamentos.CAMPO_NOME, nome)
        valores.put(TabelaMedicamentos.CAMPO_ISBN, isbn)
        valores.put(TabelaMedicamentos.CAMPO_FK_CATEGORIA, idCategoria)
    }
}