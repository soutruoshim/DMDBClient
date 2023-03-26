package com.srhdp.dmdbclient.presentation.di.core

import android.content.Context
import com.srhdp.dmdbclient.presentation.di.artist.ArtistSupComponent
import com.srhdp.dmdbclient.presentation.di.movie.MovieSubComponent
import com.srhdp.dmdbclient.presentation.di.tvshow.TvShowSupComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class,ArtistSupComponent::class, TvShowSupComponent::class])
class AppModule(private val context:Context) {
    @Singleton
    @Provides
    fun provideApplicationContext():Context{
        return context.applicationContext
    }
}