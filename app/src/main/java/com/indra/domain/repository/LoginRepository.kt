package com.indra.domain.repository

interface LoginRepository {

    suspend fun login(username: String, password: String): Boolean

}