package com.github.rtyvz.cicerone_navigation

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.androidx.AppNavigator

class MainActivity : AppCompatActivity() {

    private val navigator: Navigator = AppNavigator(this, -1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button?>(R.id.toSecondActivityButton).setOnClickListener {
            CiceroneApp.getRouter()?.navigateTo(Screens.secondActivity())
        }
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