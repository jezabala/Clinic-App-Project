package com.jesusdev.clinicaapp

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class AdminSQLiteOpenHelper(private val context: Context): SQLiteOpenHelper(context, DATABASE_NAME,
    null, DATABASE_VERSION){

    companion object{
        private const val DATABASE_NAME = "ClinicDataBase.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "usuarios"
        private const val COLUMN_ID = "id"
        private const val COLUMN_USERNAME = "username"
        private const val COLUMN_EMAIL = "email"
        private const val COLUMN_PASSWORD = "password"
        private const val COLUMN_GENDER = "gender"
        private const val COLUMN_ROLE = "role"
    }


    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = ("CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_USERNAME TEXT, $COLUMN_EMAIL TEXT, $COLUMN_PASSWORD TEXT, $COLUMN_ROLE TEXT, " +
                "$COLUMN_GENDER TEXT)")
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val dropTableQuery = "DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(dropTableQuery)
        onCreate(db)
    }

    fun insertUser(username: String, email: String, password: String, rol: String, gender: String): Long{
        val values = ContentValues().apply {
            put(COLUMN_USERNAME, username)
            put(COLUMN_EMAIL, email)
            put(COLUMN_PASSWORD, password)
            put(COLUMN_ROLE, rol)
            put(COLUMN_GENDER, gender)
        }
        val db = writableDatabase
        return db.insert(TABLE_NAME, null, values)
    }
    @SuppressLint("Range")
    fun readUser(context: Context, username: String, password: String){
        val db = readableDatabase
        val query = "SELECT $COLUMN_ROLE FROM $TABLE_NAME WHERE $COLUMN_USERNAME = ? AND $COLUMN_PASSWORD = ?"
        val cursor: Cursor = db.rawQuery(query, arrayOf(username, password))

        if (cursor.moveToFirst()){
            val role = cursor.getString(cursor.getColumnIndex(COLUMN_ROLE))
            cursor.close()
            db.close()

            when (role){
                "USUARIO" -> {
                    context.startActivity(Intent(context, MainPacientesActivity::class.java))
                }
                "ADMIN" -> {
                    context.startActivity(Intent(context, MainAdminActivity::class.java))
                }
                "MEDICO" -> {
                    context.startActivity(Intent(context, MainMedicosActivity::class.java))
                }
                else -> {
                    Toast.makeText(context, "Rol no reconocido", Toast.LENGTH_SHORT)
                }
            }

        } else {
            cursor.close()
            db.close()
        }
    }

}