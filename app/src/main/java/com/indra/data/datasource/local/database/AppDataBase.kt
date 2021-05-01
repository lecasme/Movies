package com.indra.data.datasource.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.indra.data.entity.MovieEntity
import com.indra.data.datasource.local.database.dao.MoviesDao

@Database(
    entities = [
        MovieEntity::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {

    // DAO
    abstract fun movieDao(): MoviesDao

    companion object {
        private const val databaseName = "Movie.db"
        fun buildDatabase(context: Context) = Room.databaseBuilder(context, AppDataBase::class.java, databaseName).build()
    }
}