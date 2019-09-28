package com.anggit97.moviecatalogue.di.module

import com.anggit97.moviecatalogue.BuildConfig
import com.anggit97.moviecatalogue.data.AppDataManager
import com.anggit97.moviecatalogue.data.DataManager
import com.anggit97.moviecatalogue.data.MovieService
import com.anggit97.moviecatalogue.data.remote.MovieRemoteRepository
import com.anggit97.moviecatalogue.data.remote.MovieRemoteRepositoryImpl
import com.anggit97.moviecatalogue.network.TokenInterceptor
import com.anggit97.moviecatalogue.utils.rx.AppSchedulerProvider
import com.anggit97.moviecatalogue.utils.rx.SchedulerProvider
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideAppScheduler() : SchedulerProvider{
        return AppSchedulerProvider()
    }

    @Singleton
    @Provides
    fun provideTokenInterceptor(): Interceptor {
        return TokenInterceptor(BuildConfig.API_KEY)
    }

    @Singleton
    @Provides
    fun provideClient(tokenInterceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(tokenInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieService(retrofit: Retrofit): MovieService{
        return retrofit.create(MovieService::class.java)
    }

    @Singleton
    @Provides
    fun provideMovieRemoteRepository(movieService: MovieService): MovieRemoteRepository{
        return MovieRemoteRepositoryImpl(movieService)
    }

    @Singleton
    @Provides
    fun provideAppDataManager(movieRemoteRepository: MovieRemoteRepository): DataManager{
        return AppDataManager(movieRemoteRepository)
    }
}