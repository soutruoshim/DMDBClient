package com.srhdp.dmdbclient.domain.repository

import com.srhdp.dmdbclient.data.model.artist.Artist
interface ArtistRepository {
    suspend fun getArtists():List<Artist>
    suspend fun updateArtists():List<Artist>
}