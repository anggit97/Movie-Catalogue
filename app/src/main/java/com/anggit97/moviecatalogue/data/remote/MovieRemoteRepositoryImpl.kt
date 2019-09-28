package com.anggit97.moviecatalogue.data.remote

import com.anggit97.moviecatalogue.data.MovieService
import com.anggit97.moviecatalogue.data.remote.model.MoviePopularResponse
import io.reactivex.Observable
import retrofit2.Response
import javax.inject.Inject

class MovieRemoteRepositoryImpl @Inject constructor(
    private val movieService: MovieService
) : MovieRemoteRepository {

    override fun getPopularMovie(): Observable<Response<MoviePopularResponse>> {
        return movieService.getPopularMovie()
    }

    override fun getTopRatedMovie(): Observable<Response<MoviePopularResponse>> {
        return movieService.getTopRatedMovie()
    }
}