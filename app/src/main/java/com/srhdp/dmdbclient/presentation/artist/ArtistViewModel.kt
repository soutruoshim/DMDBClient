package com.srhdp.dmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.srhdp.dmdbclient.data.model.artist.Artist
import com.srhdp.dmdbclient.domain.usecase.GetArtistUseCase
import com.srhdp.dmdbclient.domain.usecase.UpdateArtistUseCase

class ArtistViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
): ViewModel() {

    fun getArtists() = liveData {
        val artistList = getArtistUseCase.execute()
        emit(artistList)
    }

    fun updateArtists() = liveData {
         val artistList:List<Artist>? = updateArtistUseCase.execute()
         emit(artistList)
    }
}