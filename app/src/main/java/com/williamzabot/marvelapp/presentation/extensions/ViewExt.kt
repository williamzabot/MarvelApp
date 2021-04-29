package com.williamzabot.marvelapp.presentation.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl

fun ImageView.url(url: String) = Glide.with(this).load(GlideUrl(url)).into(this)