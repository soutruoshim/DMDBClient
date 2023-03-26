package com.srhdp.dmdbclient.presentation.di.core

import com.srhdp.dmdbclient.presentation.di.artist.ArtistSupComponent
import com.srhdp.dmdbclient.presentation.di.movie.MovieSubComponent
import com.srhdp.dmdbclient.presentation.di.tvshow.TvShowSupComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DatabaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class
])
interface AppComponent {
  fun movieSubComponent():MovieSubComponent.Factory
  fun artistSubComponent(): ArtistSupComponent.Factory
  fun tvShowSubComponent(): TvShowSupComponent.Factory
}