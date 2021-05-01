package com.indra.presentation.utils
import android.util.Log
import android.view.View
import com.google.gson.annotations.SerializedName
import com.indra.data.entity.MovieEntity
import com.indra.data.entity.VideoEntity
import com.indra.domain.domain.Movie
import com.indra.domain.domain.Video
import com.tmdb.tv.domain.utils.SafeClickListener
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

fun MovieEntity.toModel(): Movie {
    return Movie(
        this.id,
        this.originalTitle,
        this.posterPath,
        this.releaseDate,
        this.popularity,
        this.voteAverage,
        this.voteCount,
        this.backdropPath,
        this.overview,
        this.adult,
        this.originalLanguage
    )
}

fun VideoEntity.toModel(): Video {
    return Video(
        this.id,
        this.key,
        this.name,
        this.site,
        this.type
    )
}

fun List<MovieEntity>.toListedMovies(): List<Movie> {
    val movies = mutableListOf<Movie>()
    this.forEach{ movies.add(it.toModel()) }
    return movies
}

fun List<VideoEntity>.toListedVideos(): List<Video> {
    val movies = mutableListOf<Video>()
    this.forEach{ movies.add(it.toModel()) }
    return movies
}


fun View.setOnSafeClickListener(onSafeClick: (View) -> Unit) {
    setOnClickListener(SafeClickListener { v ->
        onSafeClick(v)
    })
}

fun View.setOnSafeClickListener(interval: Int, onSafeClick: (View) -> Unit) {
    setOnClickListener(SafeClickListener(interval) { v ->
        onSafeClick(v)
    })
}

fun String.dateFormat(): String {

    var newDate = this

    try {
        val formatOriginal = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        val formatRenewed = SimpleDateFormat("MMM dd, yyyy", Locale.US)
        val date = formatOriginal.parse(this)
        newDate = formatRenewed.format(date).toString()
    }
    catch (e: Exception) {
        Log.e("Date Converter", "This date string can`t be formated")
    }
    finally {
       return newDate
    }

}

fun String.toDate(): Date? {
    val formatOriginal = SimpleDateFormat("yyyy-MM-dd", Locale.US)
    return formatOriginal.parse(this)
}