package com.indra.data.repository

import com.indra.domain.repository.LoginRepository

class LoginRepositoryImpl: LoginRepository {

    override suspend fun login(username: String, password: String): Boolean {
        return username == VALID_USERNAME && password == VALID_PASSWORD
    }

    companion object{
        const val VALID_USERNAME = "admin"
        const val VALID_PASSWORD = "password*123"
    }

}