package com.example.myapp.Models

import java.io.Serializable

class TeamMember(
    val name: String,
    val lastName: String,
    val desc: List<String>,
    val photo: String,
    val habilities: String,
    val git: String,
    val playing: String
) : Serializable {
}