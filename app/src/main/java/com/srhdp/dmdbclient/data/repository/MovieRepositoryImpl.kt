package com.srhdp.dmdbclient.data.repository

import android.util.Log
import com.srhdp.dmdbclient.data.model.movie.Movie
import com.srhdp.dmdbclient.data.model.movie.MovieList
import com.srhdp.dmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.srhdp.dmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.srhdp.dmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.srhdp.dmdbclient.domain.repository.MovieRepository
import retrofit2.Response

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
):MovieRepository {
    override suspend fun getMovies(): List<Movie> {
       return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie> {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI():List<Movie>{
        lateinit var movieList:List<Movie>
        try {
            val response:Response<MovieList> = movieRemoteDataSource.getMovies()
            val body:MovieList? = response.body()
            if(body != null){
                movieList = body.movies
            }
        }catch (exception:Exception){
              Log.i("MyTag", exception.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDB():List<Movie>{
        lateinit var movieList:List<Movie>
        try {
           movieList = movieLocalDataSource.getMoviesFromDB()

        }catch (exception:Exception){
            Log.i("MyTag", exception.message.toString())
        }
        if(movieList.size > 0){
            return movieList
        }else{
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache():List<Movie>{
        lateinit var movieList:List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()

        }catch (exception:Exception){
            Log.i("MyTag", exception.message.toString())
        }
        if(movieList.size > 0){
            return movieList
        }else{
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}