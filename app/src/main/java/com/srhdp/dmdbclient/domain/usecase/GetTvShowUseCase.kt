package com.srhdp.dmdbclient.domain.usecase

import com.srhdp.dmdbclient.data.model.tvshow.TvShow
import com.srhdp.dmdbclient.domain.repository.TvShowRepository

class GetTvShowUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>? = tvShowRepository.getTvShows()
}