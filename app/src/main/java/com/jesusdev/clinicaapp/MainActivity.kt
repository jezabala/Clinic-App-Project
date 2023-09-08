package com.jesusdev.clinicaapp

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
        setContentView(binding.root)
         //ola dios soy yo denuevo
        binding.directNoticias.setOnClickListener {  }
        binding.directServicios.setOnClickListener {  }
        binding.directMedicos.setOnClickListener {  }
        binding.directContacto.setOnClickListener {  }
        binding.btnLogin.setOnClickListener {  }

    }

}