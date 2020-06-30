package com.starter.anny.data.modules.tmdbModule.model

import androidx.annotation.Keep

import com.google.gson.annotations.SerializedName


@Keep
data class TmdbPopularMovieRespData(
    @SerializedName("page")
    val page: Int?, // 1
    @SerializedName("results")
    val results: List<Result?>?,
    @SerializedName("total_pages")
    val totalPages: Int?, // 500
    @SerializedName("total_results")
    val totalResults: Int? // 10000
) {
    @Keep
    data class Result(
        @SerializedName("adult")
        val adult: Boolean?, // false
        @SerializedName("backdrop_path")
        val backdropPath: String?, // /5BwqwxMEjeFtdknRV792Svo0K1v.jpg
        @SerializedName("genre_ids")
        val genreIds: List<Int?>?,
        @SerializedName("id")
        val id: Int?, // 419704
        @SerializedName("original_language")
        val originalLanguage: String?, // en
        @SerializedName("original_title")
        val originalTitle: String?, // Ad Astra
        @SerializedName("overview")
        val overview: String?, // The near future, a time when both hope and hardships drive humanity to look to the stars and beyond. While a mysterious phenomenon menaces to destroy life on planet Earth, astronaut Roy McBride undertakes a mission across the immensity of space and its many perils to uncover the truth about a lost expedition that decades before boldly faced emptiness and silence in search of the unknown.
        @SerializedName("popularity")
        val popularity: Double?, // 207.629
        @SerializedName("poster_path")
        val posterPath: String?, // /xBHvZcjRiWyobQ9kxBhO6B2dtRI.jpg
        @SerializedName("release_date")
        val releaseDate: String?, // 2019-09-17
        @SerializedName("title")
        val title: String?, // Ad Astra
        @SerializedName("video")
        val video: Boolean?, // false
        @SerializedName("vote_average")
        val voteAverage: Double?, // 6.1
        @SerializedName("vote_count")
        val voteCount: Int? // 3815
    )
}