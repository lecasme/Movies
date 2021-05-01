package com.indra.data.datasource.local

import com.indra.data.entity.MovieEntity
import com.indra.data.datasource.local.database.dao.MoviesDao
import com.indra.data.datasource.local.database.dao.UserDao
import com.indra.data.entity.UserEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface UserLocalDataSource {
    suspend fun selectUser(): UserEntity?
    suspend fun insertUser(user : UserEntity)
}

class UserLocalDataSourceImpl(
    private val userDao: UserDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : UserLocalDataSource {

    override suspend fun selectUser() = withContext(ioDispatcher) {
        userDao.selectUser()
    }

    override suspend fun insertUser(user: UserEntity) = withContext(ioDispatcher){
        userDao.insert(user)
    }
}