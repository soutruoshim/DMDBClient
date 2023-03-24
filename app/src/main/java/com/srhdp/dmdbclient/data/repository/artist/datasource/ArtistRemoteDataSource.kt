package com.srhdp.dmdbclient.data.repository.artist.datasource

import com.srhdp.dmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists():Response<ArtistList>
}