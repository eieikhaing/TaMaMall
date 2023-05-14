package com.kinetichub.tamamall.base
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.kinetichub.tamamall.utilities.hideKeyboard

abstract class BaseFragment : Fragment() {
    abstract fun observeViewModel()
    protected abstract fun initViewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }

    override fun onStop() {
        super.onStop()
        hideKeyboard()
    }
}