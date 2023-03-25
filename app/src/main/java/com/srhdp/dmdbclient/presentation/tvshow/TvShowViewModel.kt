package com.srhdp.dmdbclient.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.srhdp.dmdbclient.data.model.tvshow.TvShow
import com.srhdp.dmdbclient.domain.usecase.GetTvShowUseCase

class TvShowViewModel(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: GetTvShowUseCase
): ViewModel() {

    fun getTvShows() = liveData {
        val tvShowList = getTvShowUseCase.execute()
        emit(tvShowList)
    }

    fun updateMovies() = liveData {
         val tvShowList:List<TvShow>? = updateTvShowUseCase.execute()
         emit(tvShowList)
    }
}