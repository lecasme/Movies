package com.indra.presentation.features.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.indra.R
import com.indra.databinding.FragmentDetailsBinding
import com.indra.databinding.FragmentSplashBinding
import com.indra.presentation.commons.BaseFragment
import com.indra.presentation.commons.BaseViewModel
import com.indra.presentation.features.splash.SplashFragmentDirections
import com.indra.presentation.features.splash.SplashViewModel
import com.indra.presentation.utils.API_IMG_URL
import com.indra.presentation.utils.dateFormat
import com.indra.presentation.utils.setOnSafeClickListener
import org.koin.android.viewmodel.ext.android.viewModel


class DetailsFragment : BaseFragment() {

    private val viewModel: DetailsViewModel by viewModel()
    lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imgBack.setOnSafeClickListener {
            findNavController().navigateUp()
        }

        arguments?.let { args ->

            val movie = DetailsFragmentArgs.fromBundle(args).movie

            Glide
                .with(this)
                .load("$API_IMG_URL${movie.backdropPath}")
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(binding.imgBackdropPath)

            binding.ratingBar.rating = movie.voteAverage.toFloat()/2
            binding.txtTitle.text = movie.originalTitle
            binding.txtAverage.text = movie.voteAverage.toString()
            binding.txtDescription.text = movie.overview

            val adult = if (movie.adult) resources.getString(R.string.landing_no_suitable) else resources.getString(R.string.landing_suitable)
            val information = " $adult ● ${movie.releaseDate.dateFormat()} ● ${movie.voteCount} ${resources.getString(R.string.landing_votes)}"
            binding.txtInfo.text = information

        }


    }

    override fun getViewModel(): BaseViewModel = viewModel

}