package com.kinetichub.tamamall.ui.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.kinetichub.tamamall.base.BaseFragment
import com.kinetichub.tamamall.databinding.FragmentSignUpBinding
import com.kinetichub.tamamall.utilities.popBackStack
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : BaseFragment() {
    private val signUpViewModel: SignUpViewModel by lazy { ViewModelProvider(this)[SignUpViewModel::class.java] }
    private lateinit var fragmentSignUpBinding: FragmentSignUpBinding
    override fun observeViewModel() {

    }

    override fun initViewBinding() {
        fragmentSignUpBinding = FragmentSignUpBinding.inflate(layoutInflater)
        fragmentSignUpBinding.viewModel = signUpViewModel
        fragmentSignUpBinding.lifecycleOwner = this
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentSignUpBinding.ivBack.setOnClickListener { it.popBackStack() }
        return fragmentSignUpBinding.root
    }
}