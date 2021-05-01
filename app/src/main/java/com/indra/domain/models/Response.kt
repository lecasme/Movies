package com.indra.domain.models

class Response(
    val createdBy: String,
    val description: String,
    val favoriteCount: String,
    val id: Int,
    val items : List<Movie>
)