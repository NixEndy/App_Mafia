package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.myapp.Adapters.TeamDetailsAdapter
import com.example.myapp.Models.MapMembers
import com.example.myapp.Models.TeamMembers
import com.google.gson.Gson

//En el main se pasara como parameto el nombre del integrante del equipo para que así se reciva en otra pestaña y jale alla el url con la info correspondiente

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvMembers = findViewById<RecyclerView>(R.id.rvMembers)

        val queue = Volley.newRequestQueue(this)

        val url =  "https://poketech.herokuapp.com/about"
        val jsonRequest : StringRequest = StringRequest(Request.Method.GET, url,Response.Listener{ response ->
            val gson = Gson()
            val team: MapMembers = gson.fromJson(response.toString(), MapMembers::class.java)
            val miembros: List<TeamMembers> = team.members

            rvMembers.adapter = TeamDetailsAdapter(miembros)
            rvMembers.layoutManager = LinearLayoutManager(this)
        }, Response.ErrorListener { error ->
            Log.e("Error en MainActivity", "Error en la petición {${error.toString()}")
        } )
        //Esto es para encolar peticiones y después pasarla al bloque de cóigo de a
        queue.add(jsonRequest)

    }
}