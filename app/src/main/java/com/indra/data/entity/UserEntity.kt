package com.indra.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "User")
data class UserEntity (

    @PrimaryKey
    val id: Int,
    val username: String

)
