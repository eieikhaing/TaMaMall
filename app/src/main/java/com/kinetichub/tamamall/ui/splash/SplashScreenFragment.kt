package com.kinetichub.tamamall.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.kinetichub.tamamall.base.BaseFragment
import com.kinetichub.tamamall.databinding.FragmentSplashBinding
import com.kinetichub.tamamall.navigator.AppNavigator
import com.kinetichub.tamamall.navigator.Screens
import com.kinetichub.tamamall.utilities.provideNavigator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreenFragment : BaseFragment() {
    private val viewModel: SplashViewModel by lazy { ViewModelProvider(this)[SplashViewModel::class.java] }
    private lateinit var binding: FragmentSplashBinding

    private lateinit var navigator: AppNavigator

    private val splashDisplayLength = 3000
    override fun observeViewModel() {

    }

    override fun initViewBinding() {
        binding = FragmentSplashBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigator = requireView().provideNavigator()
        Handler(Looper.getMainLooper()).postDelayed({
            navigator.navigateTo(Screens.LOGIN, null)
        }, splashDisplayLength.toLong())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}