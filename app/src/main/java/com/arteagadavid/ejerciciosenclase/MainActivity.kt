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
    lateinit var button2: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Lo utilizo para cambiar el nombre que està en el ActionBAr
        val miActionBar = supportActionBar

        // para quitar el hardcode, accedo al string de strings.xml
        val miTitle = getString(R.string.app_title) ?: "titulo de la app"

        miActionBar!!.title = miTitle

        setContentView(R.layout.activity_main)



        // Se crea el evento para el boton
        btnHazClic = findViewById(R.id.btnHazClic)

        var flag = true
        btnHazClic.setOnClickListener {
            Toast.makeText(this, "Saludos a todos", Toast.LENGTH_SHORT).show()
            if(flag){
                it.setBackgroundColor(Color.GREEN)
                flag = false
            }else{
                it.setBackgroundColor(Color.BLUE)
                flag = true

            }
        }



        // Uso de asincronismo
        // Usage
        longOperationAsync(
            longOperation = { Thread.sleep(1000L) },
            callback = { println("After one second") } //Prints after one second
        )
        println("Now")


    }

    fun inicializar(){
        btnHazClic = findViewById(R.id.btnHazClic)
        button2 = findViewById<Button>(R.id.button2)

    }

    // Otra forma de hacer eventos, se debe agregar este metodo en el layout del button.
    fun miOnClicSaludo(view: View){
        inicializar()
        val alphabet = 'a'..'z'
        val randomLetter: CharSequence = alphabet.random().toString()
        button2.text = randomLetter
    }



    fun longOperationAsync(longOperation: ()->Unit, callback: ()->Unit) {
        Thread {
            longOperation()
            callback()
        }.start()
    }



    fun EjemploListaMutableEnteros(){
        fun MutableList<Int>.swap(index1: Int, index2: Int) {
            val tmp = this[index1]
            this[index1] = this[index2]
            this[index2] = tmp
        }
        var myListInt : MutableList<Int> = mutableListOf(1,2)
        println("$myListInt")
        myListInt.swap(1,0)
        println("$myListInt")
    }

}