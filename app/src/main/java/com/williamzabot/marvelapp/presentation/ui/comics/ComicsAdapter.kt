package com.williamzabot.marvelapp.presentation.ui.comics

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.williamzabot.marvelapp.databinding.ItemComicBinding
import com.williamzabot.marvelapp.presentation.model.Comic

class ComicsAdapter(private val clickComic: (comic : Comic) -> Unit) :
    PagingDataAdapter<Comic, ComicsViewHolder>(COMIC_COMPARATOR) {

    companion object {
        private val COMIC_COMPARATOR = object : DiffUtil.ItemCallback<Comic>() {
            override fun areItemsTheSame(oldItem: Comic, newItem: Comic): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Comic, newItem: Comic): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
        getItem(position)?.let { comic ->
            holder.bind(comic)
            holder.itemView.setOnClickListener {
                clickComic(comic)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        return ComicsViewHolder(
            ItemComicBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}
