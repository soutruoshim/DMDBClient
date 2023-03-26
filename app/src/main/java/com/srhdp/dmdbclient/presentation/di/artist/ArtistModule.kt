package com.srhdp.dmdbclient.presentation.di.artist

import com.srhdp.dmdbclient.domain.usecase.GetArtistUseCase
import com.srhdp.dmdbclient.domain.usecase.UpdateArtistUseCase
import com.srhdp.dmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ):ArtistViewModelFactory{
        return ArtistViewModelFactory(
            getArtistUseCase,
            updateArtistUseCase
        )
    }
}