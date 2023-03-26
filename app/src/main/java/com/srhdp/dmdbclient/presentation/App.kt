package com.srhdp.dmdbclient.presentation

import android.app.Application
import com.srhdp.dmdbclient.BuildConfig
import com.srhdp.dmdbclient.presentation.di.Injector
import com.srhdp.dmdbclient.presentation.di.artist.ArtistSupComponent
import com.srhdp.dmdbclient.presentation.di.core.*
import com.srhdp.dmdbclient.presentation.di.movie.MovieSubComponent
import com.srhdp.dmdbclient.presentation.di.tvshow.TvShowSupComponent

class App:Application(), Injector {
    private lateinit var appComponent:AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSupComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSupComponent {
        return appComponent.artistSubComponent().create()
    }
}