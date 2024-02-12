package com.example.popayan.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BDHelper(context: Context) : SQLiteOpenHelper(context, constantes.NOM_BD, null, constantes.VERSION_BD) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(constantes.TABLA)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS coordenadas")
        onCreate(db)
    }
}
