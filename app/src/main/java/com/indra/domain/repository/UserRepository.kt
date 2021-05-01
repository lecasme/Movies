package com.indra.domain.repository

import com.indra.data.entity.UserEntity
import com.indra.domain.models.Movie
import com.indra.domain.models.User
import com.indra.domain.models.Video


interface UserRepository {

    // Cloud
    suspend fun getUser(): User?

}