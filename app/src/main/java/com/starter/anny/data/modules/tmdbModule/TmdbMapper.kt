package com.starter.anny.data.modules.tmdbModule

import com.starter.anny.data.modules.tmdbModule.model.TmdbPopularMovieRespData
import com.starter.anny.domain.tmdbmodule.entity.TmdbPopularMovieEntity

fun TmdbPopularMovieRespData.mapPopularModels() = this.run {
    TmdbPopularMovieEntity(
        page, results?.map { result ->
            result?.run {
                TmdbPopularMovieEntity.Result(
                    adult,
                    backdropPath,
                    genreIds,
                    id,
                    originalLanguage,
                    originalTitle,
                    overview,
                    popularity,
                    posterPath,
                    releaseDate,
                    title,
                    video,
                    voteAverage,
                    voteCount
                )
            }
        }, totalPages,
        totalResults
    )
}