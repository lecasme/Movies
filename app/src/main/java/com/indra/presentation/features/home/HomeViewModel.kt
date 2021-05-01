package com.indra.presentation.features.home

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.viewModelScope
import com.indra.R
import com.indra.domain.models.Movie
import com.indra.domain.usecases.MovieUseCase
import kotlinx.coroutines.launch
import com.indra.domain.models.Result
import com.indra.presentation.commons.BaseViewModel
import com.indra.presentation.utils.Event


class HomeViewModel(private val movieUseCase: MovieUseCase) : BaseViewModel() {

    val movies = MediatorLiveData<List<Movie>>()

    init {
        getMovies()
    }

    private fun getMovies() = viewModelScope.launch {
        movieUseCase.getMovies()?.let {
            movies.postValue(it)
        }
    }

}