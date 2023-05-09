package com.example.medicamentos

import android.database.sqlite.SQLiteDatabase

class TabelaClasses (db: SQLiteDatabase) : TabelaBD(db, NOME_TABELA) {
    override fun cria() {
        db.execSQL("CREATE TABLE $NOME_TABELA ($CHAVE_TABELA, descricao TEXT NOT NULL)")
    }
    companion object {
        const val NOME_TABELA = "classes"
    }
}