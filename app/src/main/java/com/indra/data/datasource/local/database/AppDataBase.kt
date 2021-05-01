package com.indra.data.datasource.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.indra.data.entity.MovieEntity
import com.indra.data.datasource.local.database.dao.MoviesDao
import com.indra.data.datasource.local.database.dao.UserDao
import com.indra.data.entity.UserEntity

@Database(
    entities = [
        MovieEntity::class,
        UserEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {

    // DAO
    abstract fun movieDao(): MoviesDao
    abstract fun userDao(): UserDao

    companion object {
        private const val databaseName = "Movie.db"
        fun buildDatabase(context: Context) = Room.databaseBuilder(context, AppDataBase::class.java, databaseName).build()
    }
}