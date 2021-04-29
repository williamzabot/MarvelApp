package com.williamzabot.marvelapp.presentation.ui.comics

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.williamzabot.marvelapp.R
import com.williamzabot.marvelapp.databinding.LoadStateItemBinding
import com.williamzabot.marvelapp.presentation.ui.comics.LoadStateAdapter.LoadStateViewHolder

class LoadStateAdapter : LoadStateAdapter<LoadStateViewHolder>() {

    override fun onBindViewHolder(
        holder: LoadStateViewHolder,
        loadState: LoadState
    ) = holder.bind(loadState)

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.load_state_item, parent, false)
        val binding = LoadStateItemBinding.bind(view)
        return LoadStateViewHolder(binding)
    }

    class LoadStateViewHolder(binding: LoadStateItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val progressBar = binding.progressbarItem

        fun bind(loadState: LoadState) {
            progressBar.isVisible = loadState is LoadState.Loading
        }
    }
}
