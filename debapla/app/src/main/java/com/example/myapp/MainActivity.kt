package com.example.myapp
import androidx.recyclerview.widget.GridLayoutManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.myapp.Adapters.TeamMembersAdapter
import com.example.myapp.Models.TeamMembers
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

//En el main se pasara como parameto el nombre del integrante del equipo para que así se reciva en otra pestaña y jale alla el url con la info correspondiente

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val queue = Volley.newRequestQueue(this)
        val url =  "https://poketech.herokuapp.com/about"
        val rvMembers = findViewById<RecyclerView>(R.id.rvMembers)
        val jsonRequest : StringRequest = StringRequest(
            Request.Method.GET,
            url,
            Response.Listener { response ->
                val gson = Gson()
                val itemType = object : TypeToken<List<TeamMembers>>() {}.type
                val members: List<TeamMembers> = gson.fromJson(response.toString(), itemType)
                rvMembers.adapter = TeamMembersAdapter (members)
                rvMembers.layoutManager = LinearLayoutManager (this)

                Log.i("members", members.toString())
            },
            Response.ErrorListener { error ->
                Log.e("JSON", "Error en la petición {${error.toString()}")
            })
        queue.add(jsonRequest)
    }
}