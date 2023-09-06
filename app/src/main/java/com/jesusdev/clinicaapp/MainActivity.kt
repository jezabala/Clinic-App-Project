package com.jesusdev.clinicaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    private lateinit var directNoticias:CardView
    private lateinit var directServicios:CardView
    private lateinit var directMedicos:CardView
    private lateinit var directContacto:CardView
    private lateinit var btnLogin:AppCompatButton
    private lateinit var btnRecuperar:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()
    }

    private fun initComponents(){
        directNoticias = findViewById(R.id.directNoticias)
        directServicios = findViewById(R.id.directServicios)
        directMedicos = findViewById(R.id.directMedicos)
        directContacto = findViewById(R.id.directContacto)
        btnLogin = findViewById(R.id.btnLogin)
        btnRecuperar = findViewById(R.id.btnRecuperarContraseña)
    }
}