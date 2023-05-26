package com.themakcym.gtd.presentation

import android.app.Application
import com.themakcym.gtd.di.Dep

class GTD: Application() {

    override fun onCreate() {
        super.onCreate()
        Dep.init(this)
    }
}