package com.example.popayan.model

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class DBManager(val context: Context) {
    lateinit var bd: SQLiteDatabase
    val bdHelper = BDHelper(context)

    fun openBdWr() {
        bd = bdHelper.writableDatabase
    }

    fun openBdRd() {
        bd = bdHelper.readableDatabase
    }


    fun insertLocationData(cordenadas: coordenadas): Long {
        openBdWr()
        val contenedor = ContentValues()
        contenedor.put("latitud", cordenadas.latitud)
        contenedor.put("longitud", cordenadas.longitud)
        contenedor.put("title", cordenadas.title)

        return bd.insert("coordenadas", null, contenedor)
    }
}