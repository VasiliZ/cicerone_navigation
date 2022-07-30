package com.github.rtyvz.cicerone_navigation

import android.content.Intent
import com.github.terrakok.cicerone.androidx.ActivityScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun secondActivity() = ActivityScreen {
        Intent(it, SecondActivity::class.java)
    }

    fun sampleFragment(id: String) = FragmentScreen {
        SampleFragment.newInstance(id)
    }
}