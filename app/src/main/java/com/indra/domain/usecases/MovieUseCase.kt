package com.indra.domain.usecases

import com.indra.domain.models.Movie
import com.indra.domain.repository.MovieRepository
import com.indra.presentation.utils.Connectivity
import java.lang.Exception
import com.indra.domain.models.Result
import com.indra.domain.models.Video

class MovieUseCase(
    private val movieRepository: MovieRepository,
    private val connectivity: Connectivity
) {

    suspend fun fetchMovies(list: Int): Result<Boolean>{
        return if(connectivity.isOnline()){
            try {
                movieRepository.fetchMovies(list)
                Result.Success(true)

            }catch (e: Exception){
                Result.Error(e)
            }
        }else{
            Result.Disconected
        }
    }

    suspend fun getMovies(): List<Movie>? {
        return movieRepository.getMovies()
    }

}