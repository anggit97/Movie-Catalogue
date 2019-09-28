package com.anggit97.moviecatalogue.base

interface Presenter<V : BaseView> {

    fun attachView(view: V)

    fun detachView()
}