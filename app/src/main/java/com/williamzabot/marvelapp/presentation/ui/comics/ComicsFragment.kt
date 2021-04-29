package com.williamzabot.marvelapp.presentation.ui.comics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.williamzabot.marvelapp.R
import com.williamzabot.marvelapp.databinding.FragmentComicsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComicsFragment : Fragment() {

    private var _binding: FragmentComicsBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<ComicsViewModel>()
    private val comicAdapter by lazy {
        ComicsAdapter { comic ->
            findNavController().navigate(ComicsFragmentDirections.comicToDetail(comic))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentComicsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        viewModel.comics.observe(viewLifecycleOwner) {
            comicAdapter.submitData(lifecycle, it)
        }
    }

    private fun initView() {
        activity?.findViewById<Toolbar>(R.id.toolbar_home)?.visibility = View.VISIBLE
        binding.apply {
            comicAdapter.run {
                recyclerViewComics.adapter = withLoadStateFooter(LoadStateAdapter())
                addLoadStateListener { state ->
                    progressBarHome.isVisible = state.refresh is LoadState.Loading
                }
            }
        }
    }
}