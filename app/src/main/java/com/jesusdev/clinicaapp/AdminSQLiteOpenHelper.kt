package com.jesusdev.clinicaapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class AdminSQLiteOpenHelper(private val context: Context): SQLiteOpenHelper(context, "clinic_app", null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE usuarios(user_id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, " +
                "user_email TEXT, user_password TEXT, user_gender TEXT, user_rol TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    private fun cerrandoBD(db:SQLiteDatabase){
        //db.close()
    }

    fun newUser(username: String, email: String, password: String, gender: String, rol: String){
        val db = this.writableDatabase
        try {
            db.beginTransaction()
            val datos = ContentValues()
            datos.put("Usuario", username)
            datos.put("Correo", email)
            datos.put("Contraseña", password)
            datos.put("Genero", gender)
            datos.put("Rol", rol)

            db.insert("usuarios", null, datos)
            db.setTransactionSuccessful()
        } catch (e:java.lang.Exception){
            e.printStackTrace()
        } finally {
            db.endTransaction()
            cerrandoBD(db)
        }
    }

}