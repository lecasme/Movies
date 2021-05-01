package com.indra.presentation.features.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.indra.R
import com.indra.domain.models.Movie
import com.indra.presentation.utils.API_IMG_URL
import com.indra.presentation.utils.dateFormat
import com.indra.presentation.utils.setOnSafeClickListener

class MovieAdapter(private val movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    lateinit var context: Context

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imgMovie)
        val card: CardView = view.findViewById(R.id.cardMovie)
        val textTitle: TextView = view.findViewById(R.id.txtTitle)
        val textYear: TextView = view.findViewById(R.id.txtYear)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        context = viewGroup.context
        return ViewHolder(
            LayoutInflater.from(viewGroup.context).inflate(
                R.layout.movie_item,
                viewGroup,
                false
            )
        )
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val movie = movies[position]
        Glide
            .with(context)
            .load("$API_IMG_URL${movie.posterPath}")
            .placeholder(R.drawable.holder)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(viewHolder.imageView)

        viewHolder.card.setOnSafeClickListener {

        }

        viewHolder.textTitle.text = movie.originalTitle
        viewHolder.textYear.text = movie.releaseDate.dateFormat()

    }

    override fun getItemCount() = movies.size

}