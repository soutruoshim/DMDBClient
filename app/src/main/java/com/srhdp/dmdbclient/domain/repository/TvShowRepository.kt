package com.srhdp.dmdbclient.domain.repository
import com.srhdp.dmdbclient.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows():List<TvShow>
    suspend fun updateTvShows():List<TvShow>
}