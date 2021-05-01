package com.indra.data.repository

import com.indra.data.datasource.local.UserLocalDataSource
import com.indra.data.entity.UserEntity
import com.indra.domain.repository.LoginRepository

class LoginRepositoryImpl(private val userLocalDataSource: UserLocalDataSource): LoginRepository {

    override suspend fun login(username: String, password: String): Boolean {

        return if(username == VALID_USERNAME && password == VALID_PASSWORD){
            userLocalDataSource.insertUser(UserEntity(1, VALID_USERNAME))
            true
        } else{
            false
        }
    }

    companion object{
        const val VALID_USERNAME = "admin"
        const val VALID_PASSWORD = "password*123"
    }

}