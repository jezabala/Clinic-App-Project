package com.jesusdev.clinicaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.jesusdev.clinicaapp.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {
    private lateinit var db: AdminSQLiteOpenHelper
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogIn: AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        db = AdminSQLiteOpenHelper(this)

        initComponents()

        btnLogIn.setOnClickListener {
            loginUser(etUsername.text.toString(), etPassword.text.toString())
        }


    }

    private fun initComponents(){
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogIn = findViewById(R.id.btnLogin)
    }

    private fun loginUser(username: String, password: String){
        val userExists = db.readUser(username, password)
        if (userExists){
            Toast.makeText(this, "Inciando Sesion", Toast.LENGTH_SHORT)
            val intent = Intent(this, MainAdminActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Error al iniciar sesion", Toast.LENGTH_SHORT)
        }

    }

}