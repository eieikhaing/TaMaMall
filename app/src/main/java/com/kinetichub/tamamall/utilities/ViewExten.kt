package com.kinetichub.tamamall.utilities

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.kinetichub.tamamall.navigator.AppNavigator
import com.kinetichub.tamamall.navigator.AppNavigatorImpl
import java.util.*

fun View.toVisible() {
    this.visibility = View.VISIBLE
}

fun View.toGone() {
    this.visibility = View.GONE
}

fun View.toInvisible() {
    this.visibility = View.GONE
}

fun View.provideNavigator(): AppNavigator {
    return AppNavigatorImpl(this)
}

fun View.popBackStack() {
    Navigation.findNavController(this).popBackStack()
}

fun String.isContainKeyword(keyword: String): Boolean {
    return if (this.isNotEmpty()) this.trim().lowercase(Locale.getDefault())
        .contains(keyword) else false
}

fun Fragment.hideKeyboard() {
    val inputMethodManager =
        this.activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    if (inputMethodManager.isAcceptingText) {
        inputMethodManager.hideSoftInputFromWindow(this.activity?.currentFocus?.windowToken, 0)
    }
}

