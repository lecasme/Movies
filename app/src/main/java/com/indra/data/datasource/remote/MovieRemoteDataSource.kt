package com.indra.data.datasource.remote

import com.indra.data.entity.ResponseEntity
import com.indra.data.datasource.remote.service.MovieService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface MovieRemoteDataSource {
    suspend fun fetchMovies(list: Int): ResponseEntity
    suspend fun fetchVideos(movieId: Int): ResponseEntity
}

class MovieRemoteDataSourceImpl(
    private val movieService: MovieService,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : MovieRemoteDataSource {

    override suspend fun fetchMovies(list: Int) = withContext(ioDispatcher) {
        movieService.fetchMovies(list)
    }

    override suspend fun fetchVideos(movieId: Int) = withContext(ioDispatcher) {
        movieService.fetchVideos(movieId)
    }
}