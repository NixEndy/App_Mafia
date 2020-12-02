package com.example.myapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.Models.TeamMembers
import com.example.myapp.R

class TeamMembersAdapter(val teamMembers: List<TeamMembers>, val parent: AppCompatActivity) : RecyclerView.Adapter<TeamMembersAdapter.ViewHolder>(){
    inner class ViewHolder(listItem: View) : RecyclerView.ViewHolder(listItem){
        val twName : TextView = itemView.findViewById(R.id.txtName)
        val twLastname : TextView = itemView.findViewById(R.id.txtLastname)
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
        holder.twLastname.text = teamMembers.lastName
    }

    override fun getItemCount(): Int {
        return teamMembers.size
    }

}