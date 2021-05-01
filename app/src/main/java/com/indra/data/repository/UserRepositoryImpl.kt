package com.indra.data.repository

import com.indra.data.datasource.local.MovieLocalDataSource
import com.indra.data.datasource.local.UserLocalDataSource
import com.indra.data.datasource.remote.MovieRemoteDataSource
import com.indra.domain.models.Movie
import com.indra.domain.models.User
import com.indra.domain.models.Video
import com.indra.domain.repository.MovieRepository
import com.indra.domain.repository.UserRepository
import com.indra.presentation.utils.toListedMovies
import com.indra.presentation.utils.toListedVideos
import com.indra.presentation.utils.toModel

class UserRepositoryImpl(private val userLocalDataSource: UserLocalDataSource): UserRepository {

    override suspend fun getUser(): User? {
       return userLocalDataSource.selectUser()?.toModel()
    }
}