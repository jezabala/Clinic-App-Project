package com.jesusdev.clinicaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jesusdev.clinicaapp.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etUsername
        binding.etPassword
        binding.btnLogin.setOnClickListener {  }
        binding.tvRePassword

    }
}