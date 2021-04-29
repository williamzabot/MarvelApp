package com.williamzabot.marvelapp.presentation.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.williamzabot.marvelapp.R
import com.williamzabot.marvelapp.presentation.ui.comics.ComicsActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
        Handler().postDelayed({
            startActivity(Intent(this, ComicsActivity::class.java))
            finish()
        }, 3000)
    }
}