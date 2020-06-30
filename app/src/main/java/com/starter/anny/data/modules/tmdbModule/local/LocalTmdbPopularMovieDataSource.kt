package com.starter.anny.data.modules.tmdbModule.local

import com.starter.anny.data.core.local.BasePersistence
import com.starter.anny.data.modules.tmdbModule.TmdbPopularMovieDataSource
import com.starter.anny.data.modules.tmdbModule.model.TmdbPopularMovieRespData

class LocalTmdbPopularMovieDataSource(tmdbPopularMoviePrefernces: TmdbPopularMoviePrefernces) :
    BasePersistence<TmdbPopularMoviePrefernces>(tmdbPopularMoviePrefernces),TmdbPopularMovieDataSource{
    override suspend fun getTmdbPopularMovie(api_key: String): TmdbPopularMovieRespData {
        TODO("Not yet implemented")
    }

}