package com.starter.anny.domain.tmdbmodule.usecase

import com.starter.anny.domain.UseCase
import com.starter.anny.domain.tmdbmodule.TmdbPopularMovieRepository
import com.starter.anny.domain.tmdbmodule.entity.TmdbPopularMovieEntity
import javax.inject.Inject

class TmdbPopularMovieUseCase @Inject constructor(private val tmdbPopularMovieRepository: TmdbPopularMovieRepository) :
    UseCase<TmdbPopularMovieUseCase.Params, TmdbPopularMovieEntity?> {

    override suspend fun invoke(params: Params): TmdbPopularMovieEntity {
        return tmdbPopularMovieRepository.getTmdbPopularMovie(params.api_key)
    }

    class Params(val api_key: String)
}