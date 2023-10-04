package com.jesusdev.clinicaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jesusdev.clinicaapp.databinding.ActivityMainPacientesBinding

class MainPacientesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainPacientesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainPacientesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.programarCita.setOnClickListener { showProgramarCita() }
        binding.historialCitas.setOnClickListener { showHistorial() }
        binding.tratamiento.setOnClickListener { showTratamiento() }
        binding.historiaClinica.setOnClickListener { showHistoriasClinicas() }
    }

    private fun showProgramarCita(){

    }

    private fun showHistorial(){

    }

    private fun showTratamiento(){

    }

    private fun showHistoriasClinicas(){

    }

}