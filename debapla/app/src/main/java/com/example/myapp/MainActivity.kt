package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.util.Log
import android.view.View

import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

//En el main se pasara como parameto el nombre del integrante del equipo para que así se reciva en otra pestaña y jale alla el url con la info correspondiente

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEvee = findViewById<button>(R.id.btnEvee)
        val btnCharmander = findViewById<button>(R.id.btnCharmander)
        val btnSnorlax = findViewById<button>(R.id.btnSnorlax)
        val btnEspurr = findViewById<button>(R.id.btnEspurr)
        val btnShinx = findViewById<button>(R.id.btnShinx)

        btnCharmander.setOnClickListener(View.OnClickListener {
            //El this hace referencia a donde estamos
            //Intent es un objeto que permite transiciones entre actividades
            val intent = Intent(this, /*Nombre de la clase a donde querremos ir*/)
            startActivity(intent)
        })
        fun btnEvee(view:view): Unit{
            val intent = Intent(this,  /*Nombre de la clase a donde querremos ir*/)
            startActivity(intent)
        }

    }
}