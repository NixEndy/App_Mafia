package com.example.myapp.Adapters

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.myapp.Models.TeamMembers
import com.example.myapp.R

class TeamMembersAdapter (val teamMembers : List <TeamMembers>) : Adapter<TeamMembersAdapter.ViewHolder>() {
    inner class ViewHolder(ListItem: View) : RecyclerView.ViewHolder(ListItem){
        val twName : TextView = itemView.findViewById(R.id.txtName)
        val twLastname : TextView = itemView.findViewById(R.id.txtLastname)
        val twDescription : TextView = itemView.findViewById(R.id.txtDescription)
        //val twHabilities : TextView = itemView.findViewById(R.id.txtHabilities)
        val twPlaying : TextView = itemView.findViewById(R.id.txtLastname)
        val twGit : TextView = itemView.findViewById(R.id.txtLastname)
        val imgUser : ImageView = itemView.findViewById(R.id.imgUser)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val memberView = inflater.inflate(R.layout.item_members, parent,false)

        return ViewHolder(memberView)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val teamMembers : TeamMembers = teamMembers.get(position)
        holder.twName.text = teamMembers.name
        holder.twLastname.text = teamMembers.lastname
        holder.twDescription.text = teamMembers.desc
        holder.twPlaying.text = teamMembers.playing
        holder.twGit.text = teamMembers.git


    }

    override fun getItemCount(): Int {
        return teamMembers.size
    }

}