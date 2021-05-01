package com.indra.data.entity

import com.google.gson.annotations.SerializedName

data class ResponseEntity(

    @SerializedName("created_by")
    val createdBy: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("favorite_count")
    val favoriteCount: String,

    @SerializedName("id")
    val id: Int,

    @SerializedName("items")
    val items : List<MovieEntity>,

    @SerializedName("results")
    val results : List<VideoEntity>

)