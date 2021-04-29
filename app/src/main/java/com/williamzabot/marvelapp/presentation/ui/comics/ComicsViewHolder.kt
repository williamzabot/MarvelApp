package com.williamzabot.marvelapp.presentation.ui.comics

import androidx.recyclerview.widget.RecyclerView
import com.williamzabot.marvelapp.databinding.ItemComicBinding
import com.williamzabot.marvelapp.presentation.extensions.url
import com.williamzabot.marvelapp.presentation.model.Comic

class ComicsViewHolder(private val binding: ItemComicBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(comic: Comic) {
        binding.apply {
            comic.image?.let {
                imageViewItem.url(it)
            }
            titleItem.text = comic.title
        }
    }
}
