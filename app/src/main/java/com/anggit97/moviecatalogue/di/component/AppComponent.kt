package com.anggit97.moviecatalogue.di.component

import android.app.Application
import com.anggit97.moviecatalogue.base.BaseApplication
import com.anggit97.moviecatalogue.di.buildermodule.ActivityBuilderModule
import com.anggit97.moviecatalogue.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class, ActivityBuilderModule::class, AppModule::class]
)
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}