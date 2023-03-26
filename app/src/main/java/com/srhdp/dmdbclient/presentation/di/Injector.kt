package com.srhdp.dmdbclient.presentation.di

import com.srhdp.dmdbclient.presentation.di.artist.ArtistSupComponent
import com.srhdp.dmdbclient.presentation.di.movie.MovieSubComponent
import com.srhdp.dmdbclient.presentation.di.tvshow.TvShowSupComponent

interface Injector {
    fun createMovieSubComponent():MovieSubComponent
    fun createTvShowSubComponent():TvShowSupComponent
    fun createArtistSubComponent(): ArtistSupComponent
}