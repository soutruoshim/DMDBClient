package com.srhdp.dmdbclient.data.repository.tvshow.datasource

import com.srhdp.dmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows():Response<TvShowList>
}