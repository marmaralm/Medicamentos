package com.example.medicamentos

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaMedicamentos (db: SQLiteDatabase) : TabelaBD(db, NOME_TABELA){
    override fun cria() {
        db.execSQL("CREATE TABLE $NOME_TABELA ($CHAVE_TABELA, titulo TEXT NOT NULL, isbn TEXT, id_categoria INTEGER NOT NULL, FOREIGN KEY (id_categoria) REFERENCES ${TabelaClasses.NOME_TABELA}(${BaseColumns._ID}) ON DELETE RESTRICT)")
    }

    companion object {
        const val NOME_TABELA = "medicamentos"
    }

}
