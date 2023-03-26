package com.srhdp.dmdbclient.presentation.di.tvshow

import com.srhdp.dmdbclient.domain.usecase.GetTvShowUseCase
import com.srhdp.dmdbclient.domain.usecase.UpdateTvShowsUseCase
import com.srhdp.dmdbclient.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowUseCase: GetTvShowUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ):TvShowViewModelFactory{
        return TvShowViewModelFactory(
            getTvShowUseCase,
            updateTvShowsUseCase
        )
    }
}