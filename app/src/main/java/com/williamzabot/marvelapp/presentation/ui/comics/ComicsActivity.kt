package com.williamzabot.marvelapp.presentation.ui.comics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.williamzabot.marvelapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class ComicsActivity : AppCompatActivity() {

    private val viewModel by viewModel<ComicsActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comics)
    }
}