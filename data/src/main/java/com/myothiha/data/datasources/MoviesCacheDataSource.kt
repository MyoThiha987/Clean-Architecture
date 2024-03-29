package com.myothiha.data.datasources

import com.myothiha.data.cache.entity.MovieEntity
import com.myothiha.domain.model.Movie
import kotlinx.coroutines.flow.Flow

/**
 * @Author myothiha
 * Created 07/03/2024 at 11:13 PM.
 **/
interface MoviesCacheDataSource {
    suspend fun saveMovies(data: List<MovieEntity>)
    fun retrieveCacheMovies(movieId: Int): Flow<List<Movie>>

}