package com.github.rtyvz.cicerone_navigation

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router

class CiceroneApp : Application() {


    companion object {
        private var cicerone: Cicerone<Router>? = null

        fun geNavigatorHolder() = cicerone?.getNavigatorHolder()
        fun getRouter() = cicerone?.router
    }

    override fun onCreate() {
        super.onCreate()

        cicerone = Cicerone.create()
    }
}