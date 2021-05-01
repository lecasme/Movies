package com.indra.data.repository

import com.indra.data.datasource.local.MovieLocalDataSource
import com.indra.data.datasource.remote.MovieRemoteDataSource
import com.indra.domain.domain.Movie
import com.indra.domain.domain.Video
import com.indra.domain.repository.MovieRepository
import com.indra.presentation.utils.toListedMovies
import com.indra.presentation.utils.toListedVideos

class MovieRepositoryImpl(private val movieRemoteDataSource: MovieRemoteDataSource,
                          private val movieLocalDataSource: MovieLocalDataSource): MovieRepository {

    override suspend fun fetchMovies(list: Int) {
        val response = movieRemoteDataSource.fetchMovies(list)
        movieLocalDataSource.insertMovies(response.items)
    }

    override suspend fun getMovies(): List<Movie> {
        return movieLocalDataSource.selectMovies().toListedMovies()
    }

    override suspend fun fetchVideos(movieId: Int): List<Video> {
        return movieRemoteDataSource.fetchVideos(movieId).results.toListedVideos()
    }

}