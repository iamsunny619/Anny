package com.starter.anny.data.modules.tmdbModule

import com.starter.anny.domain.tmdbmodule.TmdbPopularMovieRepository
import com.starter.anny.domain.tmdbmodule.entity.TmdbPopularMovieEntity
import javax.inject.Inject

class TmdbPopularMovieDataSourceRepository @Inject constructor(private val tmdbPopularMovieDataSourceFactory: TmdbPopularMovieDataSourceFactory) :
    TmdbPopularMovieRepository {
    override suspend fun getTmdbPopularMovie(api_key: String): TmdbPopularMovieEntity {
        return tmdbPopularMovieDataSourceFactory
            .remoteDataSource
            .getTmdbPopularMovie(api_key)
            .mapPopularModels()
    }
}