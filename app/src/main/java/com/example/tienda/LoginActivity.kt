package com.example.tienda

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tienda.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding= ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val tvEmail = binding.tvEmail
        val tvPassword = binding.tvPassword
        val btnLogin = binding.btnLogin

        btnLogin.setOnClickListener(){
            if(tvEmail.text.toString().equals("jose")){
                Toast.makeText(this, "Usuario correcto", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Usuario incorrecto" + tvEmail.text, Toast.LENGTH_SHORT).show()
            }
        }
    }
}