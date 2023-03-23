package com.srhdp.dmdbclient.domain.usecase

import com.srhdp.dmdbclient.data.model.artist.Artist
import com.srhdp.dmdbclient.domain.repository.ArtistRepository

class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.updateArtists()
}