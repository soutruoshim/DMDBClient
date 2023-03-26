package com.srhdp.dmdbclient.presentation.di.core

import com.srhdp.dmdbclient.data.repository.ArtistRepositoryImpl
import com.srhdp.dmdbclient.data.repository.MovieRepositoryImpl
import com.srhdp.dmdbclient.data.repository.TvShowRepositoryImpl
import com.srhdp.dmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.srhdp.dmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.srhdp.dmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.srhdp.dmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.srhdp.dmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.srhdp.dmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.srhdp.dmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.srhdp.dmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.srhdp.dmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.srhdp.dmdbclient.domain.repository.ArtistRepository
import com.srhdp.dmdbclient.domain.repository.MovieRepository
import com.srhdp.dmdbclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }
}