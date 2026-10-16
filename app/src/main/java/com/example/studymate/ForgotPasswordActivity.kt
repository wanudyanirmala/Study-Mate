package com.example.studymate

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        findViewById<Button>(R.id.btnReset).setOnClickListener {
            val email = findViewById<EditText>(R.id.etEmail).text.toString().trim()
            if (email.isBlank()) {
                Toast.makeText(this, "Masukkan email terlebih dahulu", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Instruksi pemulihan (demo) dikirim ke $email", Toast.LENGTH_LONG).show()
            }
        }
        findViewById<TextView>(R.id.tvBackLogin).setOnClickListener { finish() }
    }
}