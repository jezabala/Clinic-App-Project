package com.jesusdev.clinicaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jesusdev.clinicaapp.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var db: AdminSQLiteOpenHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AdminSQLiteOpenHelper(this)

        val username = binding.etName
        val DoB = binding.etFechaNacimiento
        val cedulaIdentidad = binding.etIdentificacion
        val telefono = binding.etTelefono
        val genero = binding.rgGender.checkedRadioButtonId

        binding.btnSignUp.setOnClickListener {  }

    }

    private fun signUpDatabase(username: String, email: String, password: String,
                               gender: String, rol: String){
        val insertRowId = db.newUser(username, email, password, gender, rol)
        /*if (insertRowId){
            Toast.makeText(this, "Registro completado!!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Registro Fallido", Toast.LENGTH_SHORT)
        } */
    }
}