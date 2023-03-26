package com.srhdp.dmdbclient.presentation.di.core

import com.srhdp.dmdbclient.data.api.TMDBService
import com.srhdp.dmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.srhdp.dmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.srhdp.dmdbclient.data.repository.movie.datasourceimpl.ArtistRemoteDataSourceImpl
import com.srhdp.dmdbclient.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.srhdp.dmdbclient.data.repository.movie.datasourceimpl.TvShowRemoteDataSourceImpl
import com.srhdp.dmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey:String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService):MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService):TvShowRemoteDataSource{
        return TvShowRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }
}