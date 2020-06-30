package com.starter.anny.domain.tmdbmodule

import com.starter.anny.domain.tmdbmodule.entity.TmdbPopularMovieEntity

interface TmdbPopularMovieRepository {

    suspend fun getTmdbPopularMovie(api_key: String): TmdbPopularMovieEntity
}