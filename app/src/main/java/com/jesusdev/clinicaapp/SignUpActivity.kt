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
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
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
        db = AdminSQLiteOpenHelper(this)
        initComponents()
        val genderSelected = rgToString(rgGender)
        btnSignUp.setOnClickListener { db.insertUser(username.text.toString(), email.text.toString(), password.text.toString(),
            rol.text.toString(), genderSelected) }

    }

    private fun initComponents(){
        username = findViewById(R.id.etNameUser)
        email = findViewById(R.id.etEmailUser)
        password = findViewById(R.id.etPassword)
        rgGender = findViewById(R.id.rgGender)
        rol = findViewById(R.id.etRoleUser)
        btnSignUp = findViewById(R.id.btnSignUp)
        rbMale = findViewById(R.id.rbMale)
        rbFemale = findViewById(R.id.rbFemale)
    }

    private fun rgToString(rg: RadioGroup): String{
        val selectedId = rg.checkedRadioButtonId
        val selectedRadioButton: RadioButton = findViewById(selectedId)
        return selectedRadioButton.text.toString()
    }

    /*private fun signUpUser(username: String, email: String, password: String,
                           rol: String, gender: String){
        val insertedRowId = db.insertUser(username, email, password, rol, gender)
        if(insertedRowId != -1L){
            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Registro Fallido", Toast.LENGTH_SHORT).show()
        }
    }*/
}