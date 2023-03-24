package com.srhdp.dmdbclient.data.repository.artist.datasource

import com.srhdp.dmdbclient.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache():List<Artist>
    suspend fun saveArtistsToCache(artists:List<Artist>)
}