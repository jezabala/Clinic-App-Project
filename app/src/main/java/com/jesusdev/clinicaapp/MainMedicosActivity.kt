package com.jesusdev.clinicaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jesusdev.clinicaapp.databinding.ActivityMainMedicosBinding

class MainMedicosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainMedicosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainMedicosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pacientes.setOnClickListener { showPacientes() }
        binding.citasPendientes.setOnClickListener { showCitasPendientes() }
        binding.tratamientos.setOnClickListener { showTratamientos() }
        binding.historialCitasComp.setOnClickListener { showHistorialCitas() }
    }

    private fun showPacientes(){

    }

    private fun showCitasPendientes(){

    }

    private fun showTratamientos(){

    }

    private fun showHistorialCitas(){

    }
}