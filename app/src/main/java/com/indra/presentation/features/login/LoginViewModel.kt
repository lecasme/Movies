package com.indra.presentation.features.login

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.viewModelScope
import com.indra.R
import com.indra.domain.models.Result
import com.indra.domain.usecases.LoginUseCase
import com.indra.presentation.commons.BaseViewModel
import com.indra.presentation.utils.Event
import kotlinx.coroutines.launch

class LoginViewModel (private val loginUseCase: LoginUseCase) : BaseViewModel() {

    private val status = MediatorLiveData<Boolean>()

    private fun login(username: String, password: String) = viewModelScope.launch {
        when(val result =  loginUseCase.login(username, password)){
            is Result.Success -> {

                if(!result.data){
                    _snackBar.value = Event(R.string.login_error)
                }else{

                }

            }
            is Result.Error -> _snackBar.value = Event(R.string.error)
            is Result.Disconected -> {
                _snackBar.value = Event(R.string.connectivity)
            }
        }
    }

}