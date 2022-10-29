package com.example.tienda

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tienda.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlin.math.log


class LoginActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        val binding= ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = Firebase.auth
        val tvEmail = binding.tvEmail
        val tvPassword = binding.tvPassword
        val btnLogin = binding.btnLogin
        val btnRedirect = binding.tvRedirectRegister

        btnRedirect.setOnClickListener(){
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener(){
            if(tvEmail.text.toString().isNotEmpty() && tvPassword.text.toString().isNotEmpty()){
                auth.signInWithEmailAndPassword(tvEmail.text.toString(),tvPassword.text.toString())
                    .addOnCompleteListener(this){ task ->
                        if(task.isSuccessful){
                            Toast.makeText(this, "Usuario correcto", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, HomeActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this,  task.exception.toString(), Toast.LENGTH_LONG).show()
                            Log.e("ERROR",task.exception.toString())
                            Log.e("ERROR",tvEmail.toString())

                        }
                    }

            }else{
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }
}