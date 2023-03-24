package com.srhdp.dmdbclient.data.repository

import android.util.Log
import com.srhdp.dmdbclient.data.model.artist.Artist
import com.srhdp.dmdbclient.data.model.artist.ArtistList
import com.srhdp.dmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.srhdp.dmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.srhdp.dmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.srhdp.dmdbclient.domain.repository.ArtistRepository
import retrofit2.Response

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
):ArtistRepository {

    suspend fun getArtistsFromAPI():List<Artist>{
        lateinit var artistList:List<Artist>
        try {
            val response:Response<ArtistList> = artistRemoteDataSource.getArtists()
            val body:ArtistList? = response.body()
            if(body != null){
                artistList = body.artists
            }
        }catch (exception:Exception){
              Log.i("MyTag", exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistsFromDB():List<Artist>{
        lateinit var artistList:List<Artist>
        try {
           artistList = artistLocalDataSource.getArtistsFromDB()

        }catch (exception:Exception){
            Log.i("MyTag", exception.message.toString())
        }
        if(artistList.size > 0){
            return artistList
        }else{
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistsFromCache():List<Artist>{
        lateinit var artistList:List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistsFromCache()

        }catch (exception:Exception){
            Log.i("MyTag", exception.message.toString())
        }
        if(artistList.size > 0){
            return artistList
        }else{
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }
        return artistList
    }

    override suspend fun getArtists(): List<Artist> {
       return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist> {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }
}