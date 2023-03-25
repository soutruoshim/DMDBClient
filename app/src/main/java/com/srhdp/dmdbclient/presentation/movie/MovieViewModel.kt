package com.srhdp.dmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.srhdp.dmdbclient.data.model.movie.Movie
import com.srhdp.dmdbclient.domain.usecase.GetMovieUseCase
import com.srhdp.dmdbclient.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMovieUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
): ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
         val movieList:List<Movie>? = updateMoviesUseCase.execute()
         emit(movieList)
    }
}