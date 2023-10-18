package com.jesusdev.clinicaapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TableLayout

class UsuariosActivity : AppCompatActivity() {
    private lateinit var tlUsuarios: TableLayout
    private lateinit var db: AdminSQLiteOpenHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuarios)
        db = AdminSQLiteOpenHelper(this)
        initComponents()

        db.llenarTabla(tlUsuarios)

    }

    private fun initComponents(){
        tlUsuarios = findViewById(R.id.tlUsuarios)
    }



}