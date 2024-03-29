package com.myothiha.data.network.dto

import com.myothiha.data.cache.entity.MovieEntity
import com.myothiha.domain.model.Movie
import com.myothiha.domain.utils.extension.orZero
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @Author myothiha
 * Created 05/03/2024 at 9:52 PM.
 **/

@Serializable
data class MovieDto(
    @SerialName("id")
    val id: Int?,
    @SerialName("original_title")
    val originalTitle: String?,
    @SerialName("overview")
    val overview: String?,
    @SerialName("popularity")
    val popularity: Double?,
    @SerialName("poster_path")
    val posterPath: String?,
    @SerialName("release_date")
    val releaseDate: String?,
    @SerialName("vote_average")
    val voteAverage: Double?,
    @SerialName("vote_count")
    val voteCount: Int?
)

fun MovieDto.toEntity(): MovieEntity {
    this.apply {
        return MovieEntity(
            id = id.orZero(),
            originalTitle = originalTitle.orEmpty(),
            overview = overview.orEmpty(),
            popularity = popularity.orZero(),
            posterPath = posterPath.orEmpty(),
            releaseDate = releaseDate.orEmpty(),
            voteAverage = voteAverage.orZero(),
            voteCount = voteCount.orZero(),
            movieType = 1,
            isLiked = false
        )
    }
}

fun MovieEntity.toDomain(): Movie {
    this.apply {
        return Movie(
            id = id,
            originalTitle = originalTitle,
            overview = overview,
            popularity = popularity,
            posterPath = posterPath,
            releaseDate = releaseDate,
            voteAverage = voteAverage,
            voteCount = voteCount,
            movieType = -1,
            isLiked = false
        )
    }
}
