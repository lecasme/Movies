package com.indra.data.repository

import com.indra.appComponent
import com.indra.domain.repository.MovieRepository
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject

class MovieRepositoryTest: KoinTest {

    private val repository by inject<MovieRepository>()

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        printLogger()
        modules(appComponent)
    }

    @Test
    fun checkMovies() {
       runBlocking {
           repository.fetchMovies(1)
       }
    }

}