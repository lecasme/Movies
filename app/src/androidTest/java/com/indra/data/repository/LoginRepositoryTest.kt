package com.indra.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.indra.domain.repository.LoginRepository
import com.indra.domain.repository.MovieRepository
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.koin.java.KoinJavaComponent.inject
import org.koin.test.KoinTest
import org.koin.test.inject

class LoginRepositoryTest : KoinTest {

    private val repository: LoginRepository by inject()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun checkLogin() {
        runBlocking {
            assertTrue(repository.login("admin", "password*123"))
        }
    }

}