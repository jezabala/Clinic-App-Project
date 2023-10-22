package com.jesusdev.clinicaapp

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class SignUpActivity : AppCompatActivity() {
    private lateinit var username: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var rgGender: RadioGroup
    private lateinit var rol: EditText
    private lateinit var btnSignUp: AppCompatButton
    private lateinit var rbMale: RadioButton
    private lateinit var rbFemale: RadioButton
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        initComponents()
        val genderSelected = rgToString(rgGender)

        btnSignUp.setOnClickListener{
            if (username.text.isNotEmpty() && email.text.isNotEmpty() && password.text.isNotEmpty()
                && genderSelected.isNotEmpty() && rol.text.isNotEmpty()){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    email.text.toString(), password.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful){
                        db.collection("users").document(username.text.toString()).set(
                            hashMapOf("username" to username.text.toString(),
                                "email" to email.text.toString(),
                                "password" to password.text.toString(),
                                "gender" to genderSelected,
                                "rol" to  rol.text.toString()
                            )
                        )
                        showHome()
                    } else showAlert()
                }
            }
        }

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

    private fun showHome(){
        Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_LONG)
        val mainHomeIntent = Intent(this, MainActivity::class.java)
        startActivity(mainHomeIntent)
        finish()
    }

    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error al registrar usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

}