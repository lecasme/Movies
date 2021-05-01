package com.indra.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
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
          val originalLanguage: String) : Parcelable


