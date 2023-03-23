package com.srhdp.dmdbclient.data.model.tvshow

import com.google.gson.annotations.SerializedName
import com.srhdp.dmdbclient.data.model.tvshow.TvShow

data class TvShowList(
    @SerializedName("results")
    val tvShows: List<TvShow>
)