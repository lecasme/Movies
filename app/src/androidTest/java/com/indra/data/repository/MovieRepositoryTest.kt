package com.indra.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.indra.data.datasource.local.MovieLocalDataSource
import com.indra.domain.repository.MovieRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject

class MovieRepositoryTest: KoinTest {

    private val repository: MovieRepository by inject()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun checkMovies() {
       runBlocking {
           repository.fetchMovies(1)
       }
    }

}