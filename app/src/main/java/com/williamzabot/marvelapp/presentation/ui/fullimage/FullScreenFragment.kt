package com.williamzabot.marvelapp.presentation.ui.fullimage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.williamzabot.marvelapp.R
import com.williamzabot.marvelapp.databinding.FragmentFullScreenBinding
import com.williamzabot.marvelapp.presentation.extensions.url

class FullScreenFragment : Fragment() {

    private var _binding : FragmentFullScreenBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<FullScreenFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFullScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.findViewById<Toolbar>(R.id.toolbar_home)?.visibility = View.GONE
        binding.apply {
            args.comic.image?.let {
                imageViewFull.url(it)
            }

            iconClose.setOnClickListener {
                findNavController().navigate(FullScreenFragmentDirections.backToDetail(args.comic))
            }
        }
    }
}