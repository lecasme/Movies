package com.indra.data.datasource.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.indra.data.entity.MovieEntity
import com.indra.data.entity.UserEntity

@Dao
abstract class UserDao : BaseDao<UserEntity>{

    @Query("SELECT * FROM user")
    abstract suspend fun selectUser(): UserEntity?

}