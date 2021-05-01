package com.indra.presentation.utils
import android.util.Log
import android.view.View
import android.view.Window
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.google.android.material.snackbar.Snackbar
import com.indra.data.entity.MovieEntity
import com.indra.data.entity.VideoEntity
import com.indra.domain.models.Movie
import com.indra.domain.models.Video
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

fun Window.getSoftInputMode(): Int {
    return attributes.softInputMode
}

fun Fragment.showSnackbar(snackbarText: String, timeLength: Int) {
    activity?.let {
        Snackbar.make(it.findViewById(android.R.id.content), snackbarText, timeLength).show()
    }
}

/**
 * SetUps
 */
fun Fragment.setupSnackbar(
    lifecycleOwner: LifecycleOwner,
    snackbarEvent: LiveData<Event<Int>>,
    timeLength: Int
) {
    snackbarEvent.observe(lifecycleOwner, { event ->
        event.getContentIfNotHandled()?.let { res ->
            context?.let { showSnackbar(it.getString(res), timeLength) }
        }
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