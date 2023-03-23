package com.srhdp.dmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.srhdp.dmdbclient.data.model.artist.Artist
import com.srhdp.dmdbclient.data.model.movie.Movie
import com.srhdp.dmdbclient.data.model.tvshow.TvShow

@Database(entities = [Movie::class, TvShow::class, Artist::class], version = 1, exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}