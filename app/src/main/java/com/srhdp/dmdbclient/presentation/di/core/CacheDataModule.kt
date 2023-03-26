package com.srhdp.dmdbclient.presentation.di.core

import com.srhdp.dmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.srhdp.dmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.srhdp.dmdbclient.data.repository.movie.datasourceimpl.ArtistCacheDataSourceImpl
import com.srhdp.dmdbclient.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import com.srhdp.dmdbclient.data.repository.movie.datasourceimpl.TvShowCacheDataSourceImpl
import com.srhdp.dmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource():MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource():ArtistCacheDataSource{
        return ArtistCacheDataSourceImpl()
    }
}