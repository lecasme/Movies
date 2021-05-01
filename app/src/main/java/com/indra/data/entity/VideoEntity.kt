package com.indra.data.entity

import com.google.gson.annotations.SerializedName

data class VideoEntity(

    @SerializedName("id")
    val id: String,

    @SerializedName("key")
    val key: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("site")
    val site: String,

    @SerializedName("type")
    val type : String)