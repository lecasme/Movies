package com.indra.presentation.features.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.indra.databinding.FragmentHomeBinding
import com.indra.presentation.commons.BaseFragment
import com.indra.presentation.commons.BaseViewModel
import com.indra.presentation.features.home.adapter.MovieAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment() {

    private val viewModel: HomeViewModel by viewModel()
    lateinit var binding: FragmentHomeBinding
    private var movieAdapter: MovieAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.movies.observe(viewLifecycleOwner, {
            movieAdapter = MovieAdapter(it)
            binding.rcvMovies.apply {
                layoutManager = GridLayoutManager(context, 3)
                adapter = movieAdapter
            }
        })

    }

    override fun getViewModel(): BaseViewModel = viewModel

}