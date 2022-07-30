package com.github.rtyvz.cicerone_navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.Replace
import com.github.terrakok.cicerone.androidx.AppNavigator

class SecondActivity : AppCompatActivity() {

    private val navigator: Navigator = object : AppNavigator(this, R.id.secondActivityFragment) {

        override fun applyCommands(commands: Array<out Command>) {
            super.applyCommands(commands)

            supportFragmentManager.executePendingTransactions()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second)

        navigator.applyCommands(arrayOf<Command>(Replace(Screens.sampleFragment("1"))))
    }

    override fun onResume() {
        super.onResume()

        CiceroneApp.geNavigatorHolder()?.setNavigator(navigator)
    }

    override fun onPause() {
        CiceroneApp.geNavigatorHolder()?.removeNavigator()

        super.onPause()
    }
}