package com.example.medicamentos

import android.content.ContentValues
import android.database.AbstractCursor
import android.database.Cursor
import android.provider.BaseColumns

data class ClasseFarmaceutica ( var descricao: String, var id: Long = -1){
    fun toContentValues() : ContentValues{
        val valores = ContentValues()

        valores.put(TabelaClasses.CAMPO_DESCRICAO, descricao)

        return valores
    }
    companion object{
        fun fromCursor(cursor: Cursor) : ClasseFarmaceutica{
            val posId = cursor.getColumnIndex(BaseColumns._ID)
            val posDescricao = cursor.getColumnIndex(TabelaClasses.CAMPO_DESCRICAO)
            //cursor.getString()
        }
        return Classe
    }
}