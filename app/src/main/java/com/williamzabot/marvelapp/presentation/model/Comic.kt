package com.williamzabot.marvelapp.presentation.model

import java.io.Serializable

data class Comic(
    val id : Int,
    val title : String,
    val image : String?,
    val thumbnail : String?,
    val price : Double?,
    val description : String?,
) : Serializable