package com.indra.domain.repository

import com.indra.domain.domain.Movie
import com.indra.domain.domain.Video


interface MovieRepository {

    // Cloud
    suspend fun fetchMovies(list: Int)
    suspend fun fetchVideos(movieId: Int): List<Video>

    // Local
    suspend fun getMovies(): List<Movie>

}