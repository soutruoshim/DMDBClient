package com.srhdp.dmdbclient.domain.usecase

import com.srhdp.dmdbclient.data.model.movie.Movie
import com.srhdp.dmdbclient.domain.repository.MovieRepository

class GetMovieUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>? = movieRepository.getMovies()
}