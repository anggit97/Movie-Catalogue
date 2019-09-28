package com.anggit97.moviecatalogue.data

import com.anggit97.moviecatalogue.data.remote.model.MoviePopularResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface MovieService {

    @GET("3/movie/popular")
    fun getPopularMovie() : Observable<Response<MoviePopularResponse>>

    @GET("3/movie/top_rated")
    fun getTopRatedMovie() : Observable<Response<MoviePopularResponse>>
}