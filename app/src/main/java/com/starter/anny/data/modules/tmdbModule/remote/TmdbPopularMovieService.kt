package com.starter.anny.data.modules.tmdbModule.remote

import com.starter.anny.data.modules.tmdbModule.model.TmdbPopularMovieRespData
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbPopularMovieService {

    @GET("3/movie/popular")
    suspend fun getTmdbPopularMovie(@Query("api_key") api_key: String): TmdbPopularMovieRespData
}