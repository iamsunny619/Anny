package com.starter.anny.data.modules.tmdbModule

import android.content.SharedPreferences
import com.google.gson.Gson
import com.starter.anny.data.core.BaseDataSourceFactory
import com.starter.anny.data.modules.tmdbModule.local.LocalTmdbPopularMovieDataSource
import com.starter.anny.data.modules.tmdbModule.local.TmdbPopularMoviePrefernces
import com.starter.anny.data.modules.tmdbModule.remote.RemoteTmdbPopularMovieDataSource
import com.starter.anny.data.util.NetworkErrorInterCeptor
import javax.inject.Inject

class TmdbPopularMovieDataSourceFactory @Inject constructor(
    sharedPreferences: SharedPreferences,
    gson: Gson,
    networkErrorInterCeptor: NetworkErrorInterCeptor
) : BaseDataSourceFactory<TmdbPopularMovieDataSource>() {
    override val localDataSource: TmdbPopularMovieDataSource =
        LocalTmdbPopularMovieDataSource(
            TmdbPopularMoviePrefernces(sharedPreferences, gson)
        )
    override val remoteDataSource: TmdbPopularMovieDataSource =
        RemoteTmdbPopularMovieDataSource(networkErrorInterCeptor)

}