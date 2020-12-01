package com.example.myapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.Models.TeamMembers
import com.example.myapp.R


//Aqui se representan cada uno de los elementos de mi recycle view
//Lo que va ente parentesis val teamMember: List sera una lista, en este caso, la lista de elementos de los miembros
//Jalamos de la carpeta Models el archivo TeamMembers ya que ahí en ese modelo es donde se deserializa el JSON y la tipamos con el tipo de dato que quiera mostrar
//Implementamos: onCreateViewHolder, onBindViewHolder, getItemCount porque es una clase abstracta

class TeamDetailsAdapter (val teamMembers: List<TeamMembers>) : RecyclerView.Adapter<TeamDetailsAdapter.ViewHolder>(){
    inner class ViewHolder (listItem: View, itemView: View) : RecyclerView.ViewHolder(itemView){
        val txtEvee : TextView = itemView.findViewById(R.id.txtEveeName)
        val txtShinx : TextView = itemView.findViewById(R.id.txtShinxName)
        val txtCharmander : TextView = itemView.findViewById(R.id.txtCharmanderName)
        val txtEspur : TextView = itemView.findViewById(R.id.txtEspurrName)
        val txtSnorlax : TextView = itemView.findViewById(R.id.txtSnorlaxName)
    }

    //Método que dicta como cada uno de los elementos de la interfaz va a cobrar sentido por cada uno de los elementos que tenemos
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val teamMembersView = inflater.inflate(R.layout.item_members, parent, false)
        return ViewHolder(teamMembersView)
    }

    //Nos entrega un elemento en viewHolder y asigna un valor a cada uno de los elementos de la interfaz visual
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val teamMembers: TeamMembers = teamMembers.get(position)
        //Holders para los texto de Nombre de cada integrante
         holder.txtEvee.text = teamMembers.name
         holder.txtShinx.text = teamMembers.name
         holder.txtCharmander.text = teamMembers.name
         holder.txtEspur.text = teamMembers.name

    }

    //Devuelve el número de elementos que tiene la lista de elementosde teamMembers para poder convertirla en algo visual
    override fun getItemCount(): Int {
        return teamMembers.size
    }


}