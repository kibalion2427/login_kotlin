package com.example.dummy_kotlin_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        variablesYConstantes()
    }

    private fun variablesYConstantes(){
        //Variables
        var myVariable = "Hello Roger"
        println(myVariable)
    }
}
