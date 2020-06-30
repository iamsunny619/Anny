package com.starter.anny.domain.tmdbmodule.entity

import androidx.annotation.Keep


@Keep
data class TmdbPopularMovieEntity(
    val page: Int?, // 1
    val results: List<Result?>?,
    val totalPages: Int?, // 500
    val totalResults: Int? // 10000
) {
    @Keep
    data class Result(
        val adult: Boolean?, // false
        val backdropPath: String?, // /5BwqwxMEjeFtdknRV792Svo0K1v.jpg
        val genreIds: List<Int?>?,
        val id: Int?, // 419704
        val originalLanguage: String?, // en
        val originalTitle: String?, // Ad Astra
        val overview: String?, // The near future, a time when both hope and hardships drive humanity to look to the stars and beyond. While a mysterious phenomenon menaces to destroy life on planet Earth, astronaut Roy McBride undertakes a mission across the immensity of space and its many perils to uncover the truth about a lost expedition that decades before boldly faced emptiness and silence in search of the unknown.
        val popularity: Double?, // 300.628
        val posterPath: String?, // /xBHvZcjRiWyobQ9kxBhO6B2dtRI.jpg
        val releaseDate: String?, // 2019-09-17
        val title: String?, // Ad Astra
        val video: Boolean?, // false
        val voteAverage: Double?, // 6.1
        val voteCount: Int? // 3811
    )
}