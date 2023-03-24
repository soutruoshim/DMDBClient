package com.srhdp.dmdbclient.data.repository.movie.datasourceimpl

import com.srhdp.dmdbclient.data.api.TMDBService
import com.srhdp.dmdbclient.data.model.artist.ArtistList

import com.srhdp.dmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val tmdbService:TMDBService, private val apiKey:String):
    ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)
}