package com.anggit97.moviecatalogue.di.buildermodule

import com.anggit97.moviecatalogue.feature.popular.PopularMovieFragment
import com.anggit97.moviecatalogue.feature.toprated.TopRatedFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector(
        modules = []
    )
    abstract fun contributePopularMovieFragment(): PopularMovieFragment

    @ContributesAndroidInjector(
        modules = []
    )
    abstract fun contributeTopRatedMovieFragment(): TopRatedFragment
}