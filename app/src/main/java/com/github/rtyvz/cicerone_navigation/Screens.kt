package com.github.rtyvz.cicerone_navigation

import android.content.Intent
import com.github.terrakok.cicerone.androidx.ActivityScreen

object Screens {

    fun secondActivity() = ActivityScreen {
        Intent(it, SecondActivity::class.java)
    }
}