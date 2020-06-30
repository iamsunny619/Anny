package com.starter.anny.data.modules.tmdbModule

import com.starter.anny.data.modules.tmdbModule.model.TmdbPopularMovieRespData

interface TmdbPopularMovieDataSource {
    suspend fun getTmdbPopularMovie(api_key: String): TmdbPopularMovieRespData
}