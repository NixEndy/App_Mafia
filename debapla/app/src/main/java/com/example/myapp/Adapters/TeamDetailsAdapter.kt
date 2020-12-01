package com.example.myapp.Adapters

import android.icu.text.LocaleDisplayNames
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.Models.MapMembers
import com.example.myapp.Models.TeamMember
import com.example.myapp.R


//Aqui se representan cada uno de los elementos de mi recycle view
//Lo que va ente parentesis val teamMember: List sera una lista, en este caso, la lista de elementos de los miembros
//Jalamos de la carpeta Models el archivo TeamMembers ya que ahí en ese modelo es donde se deserializa el JSON y la tipamos con el tipo de dato que quiera mostrar

class TeamDetailsAdapter (val teamMember: List<TeamMember>) : RecycleView.Adapter<TeamDetailsAdapter.ViewHolder>(){
    inner class ViewHolder (listItem: View) : RecyclerView.ViewHolder(){
        val txtEvee : TextView = itemView.findViewById(R.id.txtEvee)
        val txtShinx : TextView = itemView.findViewById(R.id.txtShinx)
        val txtCharmander : TextView = itemView.findViewById(R.id.txtCharmander)
        val txtEspur : TextView = itemView.findViewById(R.id.txtEspurr)
    }
}