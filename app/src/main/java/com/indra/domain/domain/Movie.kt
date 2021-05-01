package com.indra.domain.domain

import java.io.Serializable

class Movie(val id: Int,
          val originalTitle: String,
          val posterPath: String,
          val releaseDate: String,
          val popularity: Double,
          val voteAverage: Double,
          val voteCount: Int,
          val backdropPath: String,
          val overview: String,
          val adult: Boolean,
          val originalLanguage: String) : Serializable


