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

class TeamMembersAdapter (val teamMembers : List <TeamMembers>) : Adapter<TeamMembersAdapter.viewHolder>() {
    inner class viewHolder(listItem: View) : RecyclerView.ViewHolder(listItem){
        val twName : TextView = itemView.findViewById(R.id.txtName)
        val twLastname : TextView = itemView.findViewById(R.id.txtLastname)
        val twDesciption : TextView = itemView.findViewById(R.id.txtDescription)
        val twHabilities : TextView = itemView.findViewById(R.id.txtLastname)
        val twPlaying : TextView = itemView.findViewById(R.id.txtLastname)
        val twGit : TextView = itemView.findViewById(R.id.txtLastname)
        val imgUser : ImageView = itemView.findViewById(R.id.imgUser)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val teamMembersView = inflater.inflate(R.layout.item_members, parent, false)
        return viewHolder(teamMembersView)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val TeamMembers : TeamMembers = teamMembers.get(position)
        holder.twName.text = TeamMembers.name
        holder.twLastname.text = TeamMembers.lastname
        holder.twDesciption.text = TeamMembers.desc
        holder.twHabilities.text = TeamMembers.habilities
        holder.twPlaying.text = TeamMembers.playing
        holder.twGit.text = TeamMembers.git
    }

    override fun getItemCount(): Int {
        return teamMembers.size
    }
}