package com.github.rtyvz.cicerone_navigation

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.androidx.AppNavigator

class SecondActivity : AppCompatActivity() {
    private val navigator: Navigator = AppNavigator(this, -1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second)

        findViewById<Button>(R.id.toFirstActivityButton).setOnClickListener {
            CiceroneApp.getRouter()?.exit()
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