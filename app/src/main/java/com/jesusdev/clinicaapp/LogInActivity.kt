package com.jesusdev.clinicaapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.jesusdev.clinicaapp.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var tvRecPassword: TextView
    private lateinit var btnLogIn: AppCompatButton
    private val db = FirebaseFirestore.getInstance()
    companion object{
        lateinit var maincontext: Context
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        maincontext = this


        initComponents()

        btnLogIn.setOnClickListener {
            if(etEmail.text.isNotEmpty() && etPassword.text.isNotEmpty()){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(etEmail.text.toString(), etPassword.text.toString())
                    .addOnCompleteListener {
                    if (it.isSuccessful){
                        showHome(etEmail.text.toString(), etPassword.text.toString())
                        etEmail.setText("")
                        etPassword.setText("")
                    } else showAlert()
                }
            }
        }

    }

    private fun initComponents(){
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        tvRecPassword = findViewById(R.id.tvRecPassword)
        btnLogIn = findViewById(R.id.btnLogIn)
    }

    private fun showHome(email: String, password: String){
        if (email != null && password != null){
            db.collection("users").whereEqualTo("email", email).get().addOnSuccessListener {
                querySnapshot ->
                if(!querySnapshot.isEmpty){
                    val documentSnapshot = querySnapshot.documents[0]
                    when (documentSnapshot.getString("rol")){
                        "ADMIN" -> {
                            val adminHomeIntent = Intent(this, MainAdminActivity::class.java)
                            startActivity(adminHomeIntent)
                            finish()
                        }
                        "MEDICO" -> {
                            val medicoHomeIntent = Intent(this, MainMedicosActivity::class.java)
                            startActivity(medicoHomeIntent)
                            finish()
                        }
                        "USUARIO" -> {
                            val userHomeIntent = Intent(this, MainPacientesActivity::class.java)
                            startActivity(userHomeIntent)
                            finish()
                        }
                        else -> Toast.makeText(this, "Usuario no registrado", Toast.LENGTH_LONG)
                    }
                }
            }.addOnFailureListener { Toast.makeText(this, "Error de autenticacion", Toast.LENGTH_LONG) }
        }
    }

    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }


}