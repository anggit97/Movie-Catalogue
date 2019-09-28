package com.anggit97.moviecatalogue.base

import android.content.Context
import dagger.android.support.DaggerAppCompatActivity
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

abstract class BaseActivity : DaggerAppCompatActivity() {

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    protected fun getProcessScheduler(): Scheduler {
        return Schedulers.io()
    }
    protected fun getAndroidScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}