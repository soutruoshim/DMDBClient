package com.srhdp.dmdbclient.domain.repository

import com.srhdp.dmdbclient.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?
}