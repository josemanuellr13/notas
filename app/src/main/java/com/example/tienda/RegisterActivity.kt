package com.example.tienda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tienda.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        auth = Firebase.auth

        val btnRegister = binding.btnRegister
        val tvEmail = binding.tvEmail
        val tvPassword = binding.tvPassword

        btnRegister.setOnClickListener(){
            if(tvEmail.toString().isNotEmpty() && tvPassword.toString().isNotEmpty()){
                auth.createUserWithEmailAndPassword(tvEmail.toString(),tvPassword.toString())
                    .addOnCompleteListener(this){ task ->
                       if(task.isSuccessful) {
                           Toast.makeText(this, "Registro correcto", Toast.LENGTH_SHORT).show()
                        }else{
                           Toast.makeText(this, "Algo falló", Toast.LENGTH_SHORT).show()
                       }

                    }
            }
        }
    }
}