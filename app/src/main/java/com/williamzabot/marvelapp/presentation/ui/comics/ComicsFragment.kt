package com.williamzabot.marvelapp.presentation.ui.comics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.navigation.fragment.findNavController
import com.williamzabot.marvelapp.R
import com.williamzabot.marvelapp.databinding.FragmentComicsBinding

class ComicsFragment : Fragment() {

    private var _binding: FragmentComicsBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<ComicsViewModel>()
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
        observeEvents()
        if (comicAdapter.comicsList.isEmpty()) {
            viewModel.getComics(1)
        }
    }

    private fun observeEvents() {
        viewModel.viewState.observe(viewLifecycleOwner) {
            when (it) {
                is ComicsViewModel.ViewState.Running -> {
                    binding.progressBarHome.visibility = View.GONE
                }
                is ComicsViewModel.ViewState.Loading -> {
                    binding.progressBarHome.visibility = View.VISIBLE
                }
                is ComicsViewModel.ViewState.Error -> {
                    binding.progressBarHome.visibility = View.GONE
                    Toast.makeText(requireContext(), "Erro requisição", Toast.LENGTH_LONG).show()
                }
            }
        }

        viewModel.comics.observe(viewLifecycleOwner) {
            comicAdapter.comicsList = it
        }
    }

    private fun initView() {
        activity?.findViewById<Toolbar>(R.id.toolbar_home)?.visibility = View.VISIBLE
        binding.recyclerViewComics.adapter = comicAdapter
    }
}