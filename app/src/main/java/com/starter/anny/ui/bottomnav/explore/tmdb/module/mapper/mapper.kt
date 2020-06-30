package com.starter.anny.ui.bottomnav.explore.tmdb.module.mapper

import com.starter.anny.domain.tmdbmodule.entity.TmdbPopularMovieEntity
import com.starter.anny.ui.bottomnav.explore.tmdb.module.Model.TmdbPopularMoviesModel

fun TmdbPopularMovieEntity.map() = this.run {
    TmdbPopularMoviesModel(page, results?.map { result ->
        result?.run {
            TmdbPopularMoviesModel.Result(
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
    }, totalPages, totalResults)
}