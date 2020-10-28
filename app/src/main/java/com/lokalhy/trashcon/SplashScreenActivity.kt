package com.lokalhy.trashcon

import android.R.attr.*
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout


class SplashScreenActivity : AppCompatActivity() {

    lateinit var icon:ImageView
    lateinit var tv_splash:TextView
    lateinit var pull_down_anim:Animation
    lateinit var fade_anim:Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        icon = findViewById(R.id.icon)
        tv_splash = findViewById(R.id.tv_splash)

        pull_down_anim = AnimationUtils.loadAnimation(this,R.anim.pull_down_anim)
        fade_anim = AnimationUtils.loadAnimation(this,R.anim.fade_anim)

        icon.animation = pull_down_anim
        tv_splash.animation = fade_anim

        scheduleSplashScreen()
    }


    private fun scheduleSplashScreen() {
        val splashScreenDuration = getSplashScreenDuration()
        Handler().postDelayed(
            {
                tv_splash.visibility = View.GONE
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                overridePendingTransition(0,
                    R.anim.fragment_fade_exit
                )
            },
            splashScreenDuration
        )
    }

    private fun getSplashScreenDuration() = 2000L

}