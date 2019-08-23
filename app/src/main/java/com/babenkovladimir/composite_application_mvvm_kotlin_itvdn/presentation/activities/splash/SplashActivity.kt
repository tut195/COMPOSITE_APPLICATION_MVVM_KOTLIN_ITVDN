package com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.presentation.activities.splash

import android.os.Bundle
import android.os.Handler

import androidx.appcompat.app.AppCompatActivity
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.R
import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.presentation.activities.main.MainActivity

class SplashActivity : AppCompatActivity() {

    private val timer = 3000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            startActivity(MainActivity.newInstance(this))
            finish()
        }, timer)
    }
}
