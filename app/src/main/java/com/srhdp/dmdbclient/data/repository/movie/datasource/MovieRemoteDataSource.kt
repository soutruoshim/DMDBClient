package com.srhdp.dmdbclient.data.repository.movie.datasource

import com.srhdp.dmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies():Response<MovieList>
}