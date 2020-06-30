package com.starter.anny.data.modules.tmdbModule.remote

import com.starter.anny.data.core.remote.service.CommonServiceTmdb
import com.starter.anny.data.modules.tmdbModule.TmdbPopularMovieDataSource
import com.starter.anny.data.modules.tmdbModule.model.TmdbPopularMovieRespData
import com.starter.anny.data.util.NetworkErrorInterCeptor

class RemoteTmdbPopularMovieDataSource(networkErrorInterCeptor: NetworkErrorInterCeptor) :
    TmdbPopularMovieDataSource,
    CommonServiceTmdb<TmdbPopularMovieService>(networkErrorInterCeptor) {

    override suspend fun getTmdbPopularMovie(api_key: String): TmdbPopularMovieRespData {
        return networkService.getTmdbPopularMovie(api_key)
    }

    override val baseClass: Class<TmdbPopularMovieService>
        get() = TmdbPopularMovieService::class.java

}