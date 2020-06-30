package com.starter.anny.di.modules

import com.starter.anny.data.modules.tmdbModule.TmdbPopularMovieDataSourceRepository
import com.starter.anny.domain.tmdbmodule.TmdbPopularMovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TmdbModule {

    @Provides
    @Singleton
    fun provideTmdbModuleRepository(tmdbPopularMovieDataSourceRepository: TmdbPopularMovieDataSourceRepository): TmdbPopularMovieRepository =
        tmdbPopularMovieDataSourceRepository

}