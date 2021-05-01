package com.indra.data.datasource.remote.service

import com.indra.data.entity.ResponseEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {

    @GET("list/{list}")
    suspend fun fetchMovies(@Path("list") list: Int): ResponseEntity

    @GET("movie/{movieId}/videos")
    suspend fun fetchVideos(@Path("movieId") movieId: Int): ResponseEntity

}