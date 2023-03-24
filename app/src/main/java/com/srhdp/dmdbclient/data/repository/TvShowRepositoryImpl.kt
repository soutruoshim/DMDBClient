package com.srhdp.dmdbclient.data.repository

import android.util.Log
import com.srhdp.dmdbclient.data.model.tvshow.TvShow
import com.srhdp.dmdbclient.data.model.tvshow.TvShowList
import com.srhdp.dmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.srhdp.dmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.srhdp.dmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.srhdp.dmdbclient.domain.repository.TvShowRepository
import retrofit2.Response

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
):TvShowRepository {

    suspend fun getTvShowsFromAPI():List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try {
            val response:Response<TvShowList> = tvShowRemoteDataSource.getTvShows()
            val body:TvShowList? = response.body()
            if(body != null){
                tvShowList = body.tvShows
            }
        }catch (exception:Exception){
              Log.i("MyTag", exception.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowsFromDB():List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try {
           tvShowList = tvShowLocalDataSource.getTvShowsFromDB()

        }catch (exception:Exception){
            Log.i("MyTag", exception.message.toString())
        }
        if(tvShowList.size > 0){
            return tvShowList
        }else{
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowsFromCache():List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()

        }catch (exception:Exception){
            Log.i("MyTag", exception.message.toString())
        }
        if(tvShowList.size > 0){
            return tvShowList
        }else{
            tvShowList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        }
        return tvShowList
    }

    override suspend fun getTvShows(): List<TvShow> {
        return  getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow> {
        val newListOfTvShows = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }
}