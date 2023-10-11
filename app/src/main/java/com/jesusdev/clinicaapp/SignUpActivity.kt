package com.jesusdev.clinicaapp

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.jesusdev.clinicaapp.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var db: AdminSQLiteOpenHelper
    private lateinit var username: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var rgGender: RadioGroup
    private lateinit var rol: EditText
    private lateinit var btnSignUp: AppCompatButton
    private lateinit var rbMale: RadioButton
    private lateinit var rbFemale: RadioButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        initComponents()
        btnSignUp.setOnClickListener { signUpUser() }

    }

    private fun initComponents(){
        username = findViewById(R.id.etNameUser)
        email = findViewById(R.id.etEmailUser)
        password = findViewById(R.id.etEmailUser)
        rgGender = findViewById(R.id.rgGender)
        rol = findViewById(R.id.etRoleUser)
        btnSignUp = findViewById(R.id.btnSignUp)
        rbMale = findViewById(R.id.rbMale)
        rbFemale = findViewById(R.id.rbFemale)
    }

    private fun signUpUser(){
        db = AdminSQLiteOpenHelper(this)
        var db = db.writableDatabase
        var user = username.text.toString()
        var correo = email.text.toString()
        var pass = password.text.toString()
        val selectedId = rgGender.checkedRadioButtonId
        val selectedRadioButton: RadioButton = rgGender.findViewById(selectedId)
        val gender: String = when(selectedRadioButton.text){
            "Masculino" -> "Masculino"
            "Femenino" -> "Femenino"
            else -> ""
        }
        var role = rol.text.toString()

        if (user.isNotEmpty() && correo.isNotEmpty() && pass.isNotEmpty() && gender.isNotEmpty() && role.isNotEmpty()){
            var registroUsuario = ContentValues()
            registroUsuario.put("username", user)
            registroUsuario.put("email", correo)
            registroUsuario.put("password", pass)
            registroUsuario.put("gender", gender)
            registroUsuario.put("rol", role)
            db.insert("usuarios", null, registroUsuario)
            Toast.makeText(this, "Se registro exitosamente!", Toast.LENGTH_SHORT)
        } else {
            Toast.makeText(this, "No pueden haber campos en blanco!", Toast.LENGTH_SHORT)
        }
    }
}