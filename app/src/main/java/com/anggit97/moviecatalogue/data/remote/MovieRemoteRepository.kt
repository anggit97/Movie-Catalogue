package com.anggit97.moviecatalogue.data.remote

import com.anggit97.moviecatalogue.data.remote.model.MoviePopularResponse
import io.reactivex.Observable
import retrofit2.Response

interface MovieRemoteRepository {

    fun getPopularMovie() : Observable<Response<MoviePopularResponse>>

    fun getTopRatedMovie() : Observable<Response<MoviePopularResponse>>
}