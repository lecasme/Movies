package com.indra.presentation.features.splash

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.viewModelScope
import com.indra.R
import com.indra.domain.usecases.MovieUseCase
import kotlinx.coroutines.launch
import com.indra.domain.models.Result
import com.indra.domain.usecases.UserUseCase
import com.indra.presentation.commons.BaseViewModel
import com.indra.presentation.utils.Event


class SplashViewModel(private val movieUseCase: MovieUseCase, private val userUseCase: UserUseCase) : BaseViewModel() {

    val status = MediatorLiveData<Boolean>()

    init {
        getMovies()
    }

    private fun getMovies() = viewModelScope.launch {
        when(movieUseCase.fetchMovies(1)){
            is Result.Success -> {
                userUseCase.getUser()?.let {
                    status.postValue(true)
                } ?: kotlin.run {
                    status.postValue(false)
                }
            }
            is Result.Error -> _snackBar.value = Event(R.string.error)
            is Result.Disconected -> {
                _snackBar.value = Event(R.string.connectivity)
            }
        }
    }

}