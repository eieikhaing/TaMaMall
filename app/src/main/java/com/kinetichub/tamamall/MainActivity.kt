package com.kinetichub.tamamall

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kinetichub.tamamall.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        navController = findNavController(R.id.nav_host_fragment_activity_main)
        navController.addOnDestinationChangedListener{ _, destination, _ ->
            if (destination.id == R.id.splashScreenFragment || destination.id == R.id.loginFragment) {
                navView.visibility = View.GONE
                return@addOnDestinationChangedListener
            }else{
                navView.visibility = View.VISIBLE
            }
        }
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
       /* val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )*/
       // setupActionBarWithNavController(navController, appBarConfiguration)

        navView.setupWithNavController(navController)


    }
   override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    /* override fun onBackPressed() {
        if (binding.navView.selectedItemId == R.id.navigation_dashboard || binding.navView.selectedItemId == R.id.navigation_notifications) {
            // Navigate back to the home fragment
            binding.navView.selectedItemId = R.id.navigation_home;
        } else {
            // Exit the app
            this.onBackPressed();
        }
    }*/



    
}