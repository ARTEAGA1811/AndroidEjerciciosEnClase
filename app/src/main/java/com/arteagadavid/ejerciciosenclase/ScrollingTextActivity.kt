package com.arteagadavid.ejerciciosenclase

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.arteagadavid.ejerciciosenclase.databinding.ActivityScrollingTextBinding

class ScrollingTextActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingTextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingTextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editTextDatos = findViewById<EditText>(R.id.editTextDatos)
        val textViewMostrarTexto = findViewById<TextView>(R.id.textViewMostrarTexto)
        val buttonGuardar = findViewById<Button>(R.id.buttonGuardar)
        val buttonLimpiar = findViewById<Button>(R.id.buttonLimpiar)


        textViewMostrarTexto.movementMethod = ScrollingMovementMethod()
        buttonGuardar.setOnClickListener {
            textViewMostrarTexto.text = editTextDatos.text
        }
        buttonLimpiar.setOnClickListener {
            textViewMostrarTexto.text = ""
            editTextDatos.setText("")
        }
    }
}