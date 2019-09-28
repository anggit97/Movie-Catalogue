package com.anggit97.moviecatalogue.data

import com.anggit97.moviecatalogue.data.remote.MovieRemoteRepository
import com.anggit97.moviecatalogue.data.remote.model.MoviePopularResponse
import io.reactivex.Observable
import retrofit2.Response
import javax.inject.Inject

class AppDataManager @Inject constructor(
    private val movieRemoteRepository: MovieRemoteRepository
) : DataManager {

    override fun getTopRatedMovie(): Observable<Response<MoviePopularResponse>> {
        return movieRemoteRepository.getTopRatedMovie()
    }

    override fun getPopularMovie(): Observable<Response<MoviePopularResponse>> {
        return movieRemoteRepository.getTopRatedMovie()
    }
}