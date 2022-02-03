package uz.umarxon.retrofit.models

import java.io.Serializable

data class Movie(
    val bio: String,
    val createdby: String,
    val firstappearance: String,
    val imageurl: String,
    val name: String,
    val publisher: String,
    val realname: String,
    val team: String
):Serializable