package com.example.medicamentos

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class BDInstrumentedTest {
    private fun getAppContext():Context= InstrumentationRegistry.getInstrumentation().targetContext

    @Before

    fun apagaBaseDados(){
        getAppContext().deleteDatabase(BDMedicamentosOpenHelper.NOME_BASE_DADOS)
    }
    @Test
    fun consegueAbrirBaseDados() {
        // Context of the app under test.
        val openHelper = BDMedicamentosOpenHelper(getAppContext())
        val bd = openHelper.readableDatabase
        assert(bd.isOpen)
        val appContext = getAppContext()
        assertEquals("com.example.medicamentos", appContext.packageName)
    }

    private fun insereClasse(bd : SQLiteDatabase, classes: TabelaClasses){
        val classe = ClasseFarmaceutica("Anti-inflamatório")
        val id = TabelaClasses(bd).insere(classe.toContentValues())
    }
    @Test
    fun consegueInserirCategorias(){
        val bd = getWritableDataBase()

        val classe = ClasseFarmaceutica("Antibiótico")

        var id = TabelaClasses(bd).insere(classe.toContentValues())
        assertNotEquals(-1, id)
    }

    private fun getWritableDataBase(): SQLiteDatabase {
        val openHelper = BDMedicamentosOpenHelper(getAppContext())
        val bd = openHelper.writableDatabase
        return bd
    }

    @Test
    fun consegueInserirMedicamentos(){
        val bd = getWritableDataBase()

        val classe = ClasseFarmaceutica("Anti-inflamatório")
        insereClasse(bd, classeAntiInflam)

        val medicamentos


    }

    private fun insereMedicamento(bs:SQLiteDatabase, medicamentos: Medicamentos){
        medicamentos.id = TabelaMedicamentos(bd).insere(medicamentos.toContentValues())
        assertNotEquals(-1, medicamentos.id)
    }

    @Test
    fun consegueLerClasses(){
        val bd = getWritableDataBase()

        val classe = ClasseFarmaceutica("Anti-hipertensor")
        insereClasse(bd, classeAntiHipert)

        val cursor = TabelaClasses(bd).consulta(TabelaClasses.CAMPOS, "${BaseColumns._ID}=?", arrayOf(classeAntihipert.id.toString()), null, null, null)

        assert(cursor.moveToNext())

        val classeBD = ClasseFarmaceutica.fromCursor(cursor)

        assertEquals(classeAntihiper, classeBD)

        val cursorTodasClasses = tabelaClasses.consulta()

        assert(cursorTodasClasses.count>1)

    }

}