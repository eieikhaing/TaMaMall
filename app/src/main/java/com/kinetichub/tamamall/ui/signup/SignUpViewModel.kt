package com.kinetichub.tamamall.ui.signup

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kinetichub.tamamall.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor() : BaseViewModel() {
    var email = ObservableField<String>("")
    var name = ObservableField<String>("")
    var phoneNo = ObservableField<String>("")
    var dob = ObservableField<String>("")
    var validationResult = MutableLiveData<Boolean>(false)

    private val _nameError = MutableLiveData<String>()
    private val _dobError = MutableLiveData<String>()
    private val _emailError = MutableLiveData<String>()
    private val _phoneError = MutableLiveData<String>()

    val nameError: LiveData<String>
        get() = _nameError

    val dobError: LiveData<String>
        get() = _dobError

    val emailError: LiveData<String>
        get() = _emailError

    val phoneError: LiveData<String>
        get() = _phoneError

    private fun getEmail() = email.get().toString()

    private fun getName() = name.get().toString()

    private fun getPhoneNo() = phoneNo.get().toString()

    private fun getDob() = dob.get().toString()
}