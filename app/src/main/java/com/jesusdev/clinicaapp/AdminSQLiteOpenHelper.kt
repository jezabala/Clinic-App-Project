package com.jesusdev.clinicaapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

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
    fun readUser(username: String, password: String): Boolean{
        val db = readableDatabase
        val selection = "$COLUMN_USERNAME = ? AND $COLUMN_PASSWORD = ?"
        val selectionArgs = arrayOf(username, password)
        val cursor = db.query(TABLE_NAME, null, selection, selectionArgs, null, null, null)

        val userExists = cursor.count > 0
        cursor.close()
        return userExists
    }

}