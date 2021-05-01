package com.indra.presentation.features.splash

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.viewModelScope
import com.indra.R
import com.indra.domain.usecases.MovieUseCase
import kotlinx.coroutines.launch
import com.indra.domain.models.Result
import com.indra.presentation.commons.BaseViewModel
import com.indra.presentation.utils.Event


class SplashViewModel(private val movieUseCase: MovieUseCase) : BaseViewModel() {

    val status = MediatorLiveData<Boolean>()

    init {
        getMovies()
    }

    private fun getMovies() = viewModelScope.launch {
        when(val result =  movieUseCase.fetchMovies(1)){
            is Result.Success -> {
                status.postValue(true)
            }
            is Result.Error -> _snackBar.value = Event(R.string.error)
            is Result.Disconected -> {
                _snackBar.value = Event(R.string.connectivity)
            }
        }
    }

}