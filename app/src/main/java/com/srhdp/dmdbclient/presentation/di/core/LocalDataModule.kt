package com.srhdp.dmdbclient.presentation.di.core

import com.srhdp.dmdbclient.data.db.ArtistDao
import com.srhdp.dmdbclient.data.db.MovieDao
import com.srhdp.dmdbclient.data.db.TvShowDao
import com.srhdp.dmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.srhdp.dmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.srhdp.dmdbclient.data.repository.movie.datasourceimpl.ArtistLocalDataSourceImpl
import com.srhdp.dmdbclient.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.srhdp.dmdbclient.data.repository.movie.datasourceimpl.TvShowLocalDataSourceImpl
import com.srhdp.dmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao):MovieLocalDataSource{
         return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao):ArtistLocalDataSource{
        return ArtistLocalDataSourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao):TvShowLocalDataSource{
        return TvShowLocalDataSourceImpl(tvShowDao)
    }
}