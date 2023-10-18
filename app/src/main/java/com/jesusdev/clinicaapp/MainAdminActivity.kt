package com.jesusdev.clinicaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jesusdev.clinicaapp.databinding.ActivityMainAdminBinding

class MainAdminActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainAdminBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.users.setOnClickListener { showUsers() }
        binding.reports.setOnClickListener { showReports() }
        binding.historial.setOnClickListener { showHistorial() }
        binding.notificaciones.setOnClickListener { showNotificaciones() }
    }

    private fun showUsers(){
        val intent = Intent(this, UsuariosActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun showReports(){

    }

    private fun showHistorial(){

    }

    private fun showNotificaciones(){

    }

}