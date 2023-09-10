package com.jesusdev.clinicaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jesusdev.clinicaapp.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = binding.etName
        val date = binding.etFechaNacimiento
        val identification = binding.etIdentificacion
        val phoneNumber = binding.etTelefono
        val gender = binding.rgGender.checkedRadioButtonId

        binding.btnSignUp.setOnClickListener {  }

    }
}