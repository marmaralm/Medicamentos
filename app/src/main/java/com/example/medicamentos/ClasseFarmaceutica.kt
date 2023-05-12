package com.example.medicamentos

import android.content.ContentValues

data class ClasseFarmaceutica ( var descricao: String, var id: Long = -1){
    fun toContentValues() : ContentValues{
        val valores = ContentValues()

        valores.put(TabelaClasses.CAMPO_DESCRICAO, descricao)

        return valores
    }
}