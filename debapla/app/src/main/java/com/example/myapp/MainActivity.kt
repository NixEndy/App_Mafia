package com.example.myapp
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
import com.example.myapp.Models.Team
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
                Log.i("CitiesJSON", response.toString())
                val gson = Gson()
                val team: Team = gson.fromJson(response.toString(), Team::class.java)

                val members: List<TeamMembers> = team.equipo
                rvMembers.adapter = TeamMembersAdapter(members, this)
                rvMembers.layoutManager = LinearLayoutManager (this)

            },Response.ErrorListener { error ->
                Log.e("JSON", "Error en la petición {${error.toString()}")
            })
        queue.add(jsonRequest)
    }
}