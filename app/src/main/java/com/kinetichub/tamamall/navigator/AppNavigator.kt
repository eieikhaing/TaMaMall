package com.kinetichub.tamamall.navigator

import android.os.Bundle

interface AppNavigator {
    fun navigateTo(screens: Screens, argus: Bundle?)
}

