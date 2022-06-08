package com.arteagadavid.ejerciciosenclase

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    // Aqui debo hacer la declaracion de mis variables
    // El lateinit lo uso para decir que lo inicializamos despues
    lateinit var btnHazClic: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Lo utilizo para cambiar el nombre que està en el ActionBAr
        val miActionBar = supportActionBar;

        // para quitar el hardcode, accedo al string de strings.xml
        val miTitle = getString(R.string.app_title) ?: "titulo de la app"

        miActionBar!!.title = miTitle

        setContentView(R.layout.activity_main)



        // Se crea el evento para el boton
        btnHazClic = findViewById(R.id.btnHazClic)

        var flag = true
        btnHazClic.setOnClickListener {
            Toast.makeText(this, "Saludos a todos", Toast.LENGTH_LONG).show()
            if(flag){
                it.setBackgroundColor(Color.GREEN)
                flag = false
            }else{
                it.setBackgroundColor(Color.BLUE)
                flag = true
            }
        }


    }
}