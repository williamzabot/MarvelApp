package com.williamzabot.marvelapp.presentation.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.williamzabot.marvelapp.R
import com.williamzabot.marvelapp.databinding.FragmentDetailBinding
import com.williamzabot.marvelapp.presentation.extensions.url
import com.williamzabot.marvelapp.presentation.ui.comics.ComicsActivityViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val navController by lazy { findNavController() }
    private val viewModel by sharedViewModel<ComicsActivityViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()

    }

    private fun initView() {
        activity?.findViewById<Toolbar>(R.id.toolbar_home)?.visibility = View.GONE
        val comic = viewModel.ultimoComicClicado
        binding.apply {
            comic?.thumbnail?.let {
                bannerDetail.url(it)
            }
            if (comic?.price != null) {
                priceDetail.text = comic.price.toString()
            } else {
                titlePrice.visibility = View.GONE
            }
            titleDetail.text = comic?.title
            comic?.image?.let { url ->
                imageViewDetail.url(url)
            }
            comic?.description?.let {
                descriptionDetail.text = it
            }
            iconBack.setOnClickListener {
                navController.popBackStack(R.id.comicFragment, false)
            }

            constraintImageDetail.setOnClickListener {
                navController.navigate(DetailFragmentDirections.detailToFull(comic!!))
            }
        }
    }


}