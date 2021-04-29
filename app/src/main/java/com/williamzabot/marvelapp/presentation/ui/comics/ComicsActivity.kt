package com.williamzabot.marvelapp.presentation.ui.comics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.williamzabot.marvelapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComicsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comics)
    }
}