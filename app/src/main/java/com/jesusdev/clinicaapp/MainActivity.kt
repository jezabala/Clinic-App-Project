package com.jesusdev.clinicaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import com.jesusdev.clinicaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.directNoticias.setOnClickListener { showDirectNoticias() }
        binding.directServicios.setOnClickListener { showDirectServicios() }
        binding.directMedicos.setOnClickListener { showDirectMedicos() }
        binding.directContacto.setOnClickListener { showDirectContacto() }
        binding.btnLogin.setOnClickListener { showLogInForm() }

    }

    // Estas funciones permiten conectar la pantalla principal
    // con las otras pantallas
    private fun showLogInForm(){
        val intent = Intent(this, LogInActivity::class.java)
        startActivity(intent)
    }

    private fun showDirectNoticias(){}

    private fun showDirectServicios(){}

    private fun showDirectMedicos(){}

    private fun showDirectContacto(){}

}