package com.jesusdev.clinicaapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.jesusdev.clinicaapp.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {
    private lateinit var db: AdminSQLiteOpenHelper
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var tvRecPassword: TextView
    private lateinit var btnLogIn: AppCompatButton
    companion object{
        lateinit var maincontext: Context
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        maincontext = this

        db = AdminSQLiteOpenHelper(maincontext)

        initComponents()

        tvRecPassword.setOnClickListener {  }

        btnLogIn.setOnClickListener {
            db.readUser(maincontext, etUsername.text.toString(), etPassword.text.toString())
            etUsername.setText("")
            etPassword.setText("")
        }

    }

    private fun initComponents(){
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        tvRecPassword = findViewById(R.id.tvRecPassword)
        btnLogIn = findViewById(R.id.btnLogin)
    }

}