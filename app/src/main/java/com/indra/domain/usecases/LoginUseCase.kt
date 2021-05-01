package com.indra.domain.usecases

import com.indra.domain.models.Result
import com.indra.domain.repository.LoginRepository

class LoginUseCase(private val loginRepository: LoginRepository) {

    suspend fun login(username: String, password: String): Result<Boolean> {
        return Result.Success(loginRepository.login(username, password))
    }

}