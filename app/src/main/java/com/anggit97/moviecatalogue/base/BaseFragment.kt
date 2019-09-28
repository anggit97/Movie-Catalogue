package com.anggit97.moviecatalogue.base

import android.app.Activity
import android.content.Context
import dagger.android.support.DaggerFragment
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


abstract class BaseFragment : DaggerFragment() {

    protected lateinit var mContext: Context
    private lateinit var mActivity: Activity

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context != null) {
            mContext = context
        }
        mActivity = context as Activity
    }

    protected fun getProcessScheduler(): Scheduler {
        return Schedulers.io()
    }

    protected fun getAndroidScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}
