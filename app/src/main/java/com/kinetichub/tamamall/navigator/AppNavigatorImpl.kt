package com.kinetichub.tamamall.navigator

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.kinetichub.tamamall.R


class AppNavigatorImpl(private val view: View) : AppNavigator {
    override fun navigateTo(screens: Screens, argus: Bundle?) {
        val action = when (screens) {
            Screens.LOGIN -> R.id.action_splashScreenFragment_to_loginFragment
            Screens.LOGIN_TO_SIGNUP -> R.id.action_loginFragment_to_signUpFragment
            Screens.LOGIN_TO_DASHBOARD -> R.id.action_loginFragment_to_mobile_navigation
            Screens.DASH_TO_NOTI -> R.id.action_navigation_dashboard_to_testFragment

        }
        Navigation.findNavController(view).navigate(action, argus)
    }
}
