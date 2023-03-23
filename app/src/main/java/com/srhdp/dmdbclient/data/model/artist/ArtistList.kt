package com.srhdp.dmdbclient.data.model.artist


import com.google.gson.annotations.SerializedName
import com.srhdp.dmdbclient.data.model.artist.Artist

data class ArtistList(
    @SerializedName("results")
    val artists: List<Artist>
)