package com.indra.domain.usecases

import com.indra.domain.models.User
import com.indra.domain.repository.UserRepository

class UserUseCase(
    private val userRepository: UserRepository) {

    suspend fun getUser(): User?{
        return userRepository.getUser()
    }

}