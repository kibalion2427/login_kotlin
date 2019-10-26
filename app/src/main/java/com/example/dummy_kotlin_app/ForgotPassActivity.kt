package com.example.dummy_kotlin_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import android.content.Intent
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast


class ForgotPassActivity : AppCompatActivity() {

    private lateinit var txtEmail:EditText
    private lateinit var auth:FirebaseAuth
    private lateinit var progressBar:ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pass)

        txtEmail = findViewById(R.id.txtEmail)
        auth = FirebaseAuth.getInstance()
        progressBar = findViewById(R.id.progressBarForgotPass)
    }

    fun send(view:View){
        val email = txtEmail.text.toString()
        if(!TextUtils.isEmpty(email)){
            auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(this){task ->
                    if(task.isSuccessful){
                        progressBar.visibility = View.VISIBLE
                        startActivity(Intent(this,LoginActivity::class.java))
                    }else{
                        Toast.makeText(this,"Error al enviar el email",Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
}
