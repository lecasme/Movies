package com.indra.data.datasource.local

import com.indra.data.entity.MovieEntity
import com.indra.data.datasource.local.database.dao.MoviesDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface MovieLocalDataSource {
    suspend fun selectMovies(): List<MovieEntity>?
    suspend fun insertMovies(movies : List<MovieEntity>)
}

class MovieLocalDataSourceImpl(
    private val moviesDao: MoviesDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : MovieLocalDataSource {

    override suspend fun selectMovies(): List<MovieEntity>? = withContext(ioDispatcher) {
        moviesDao.selectMovies()
    }

    override suspend fun insertMovies(movies : List<MovieEntity>): Unit = withContext(ioDispatcher) {
        moviesDao.insertMovies(movies)
    }

}