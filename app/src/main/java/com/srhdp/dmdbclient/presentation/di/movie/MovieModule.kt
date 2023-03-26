package com.srhdp.dmdbclient.presentation.di.movie

import com.srhdp.dmdbclient.domain.usecase.GetMovieUseCase
import com.srhdp.dmdbclient.domain.usecase.UpdateMoviesUseCase
import com.srhdp.dmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMovieUseCase: GetMovieUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ):MovieViewModelFactory{
        return MovieViewModelFactory(
            getMovieUseCase,
            updateMoviesUseCase
        )
    }
}