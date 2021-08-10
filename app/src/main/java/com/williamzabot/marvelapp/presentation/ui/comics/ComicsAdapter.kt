package com.williamzabot.marvelapp.presentation.ui.comics

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.williamzabot.marvelapp.databinding.ItemComicBinding
import com.williamzabot.marvelapp.presentation.model.Comic

class ComicsAdapter(private val clickComic: (comic: Comic) -> Unit) :
    RecyclerView.Adapter<ComicsViewHolder>() {

    var comicsList = listOf<Comic>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
        val comic = comicsList[position]
        holder.bind(comic)
        holder.itemView.setOnClickListener {
            clickComic(comic)
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

    override fun getItemCount(): Int {
        return comicsList.size
    }
}
