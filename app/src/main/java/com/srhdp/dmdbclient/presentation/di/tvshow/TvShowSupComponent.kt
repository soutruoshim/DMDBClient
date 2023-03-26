package com.srhdp.dmdbclient.presentation.di.tvshow

import com.srhdp.dmdbclient.presentation.movie.MovieActivity
import com.srhdp.dmdbclient.presentation.tvshow.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSupComponent {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():TvShowSupComponent
    }
}