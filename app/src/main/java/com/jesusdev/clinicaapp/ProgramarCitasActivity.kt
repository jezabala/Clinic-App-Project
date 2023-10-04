package com.jesusdev.clinicaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jesusdev.clinicaapp.databinding.ActivityProgramarCitasBinding

class ProgramarCitasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProgramarCitasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProgramarCitasBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}