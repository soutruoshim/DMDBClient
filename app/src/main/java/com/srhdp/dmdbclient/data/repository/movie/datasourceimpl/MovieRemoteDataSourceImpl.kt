package com.srhdp.dmdbclient.data.repository.movie.datasourceimpl

import com.srhdp.dmdbclient.data.api.TMDBService
import com.srhdp.dmdbclient.data.model.movie.MovieList
import com.srhdp.dmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbService:TMDBService, private val apiKey:String):
    MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}