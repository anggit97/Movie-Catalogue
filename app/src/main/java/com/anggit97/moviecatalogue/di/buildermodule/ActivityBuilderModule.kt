package com.anggit97.moviecatalogue.di.buildermodule

import com.anggit97.moviecatalogue.feature.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(
        modules = [FragmentBuilderModule::class]
    )
    abstract fun contributeMainActivity(): MainActivity
}