package com.kinetichub.tamamall.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kinetichub.tamamall.base.BaseViewModel
import com.kinetichub.tamamall.models.login.LoginServerResponse
import com.kinetichub.tamamall.repository.DataRepository
import com.kinetichub.tamamall.repository.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val dataRepository: DataRepository,
) : BaseViewModel() {
    private val _loginServerResponse = MutableLiveData<Resource<LoginServerResponse>>()
  //  val loginServerResponse: LiveData<Resource<LoginServerResponse>> get() = _loginServerResponse

     fun callApi() {
        _loginServerResponse.value = Resource.Loading()
        viewModelScope.launch {
            _loginServerResponse.value =
                dataRepository.remote.loginRequest(
                    "phoneNo.get().toString().trim()",
                    "password.get().toString().trim()"
                ) as Resource<LoginServerResponse>
        }
    }
}