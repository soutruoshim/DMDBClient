package com.srhdp.dmdbclient.data.model.movie
import com.google.gson.annotations.SerializedName
import com.srhdp.dmdbclient.data.model.movie.Movie

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>
)