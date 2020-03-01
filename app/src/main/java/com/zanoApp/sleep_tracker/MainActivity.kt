package com.zanoApp.sleep_tracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.navigation.NavigationView
import com.zanoApp.sleep_tracker.databinding.MainActivityBinding
import com.zanoApp.sleep_tracker.views.MainFragment
import kotlinx.android.synthetic.main.bottom_app_bar.*

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)


        val host: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.homeFragment)
        )
        val navController = host.navController

        onSupportNavigateUp()
        setupBottomNavBar(navController)

        bar.replaceMenu(R.menu.bottom_app_bar_menu)
        bar.setNavigationOnClickListener {

            fab.setOnClickListener {
                Toast.makeText(this, "starting your sleeping session", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun setupBottomNavBar(navController: NavController) {

        val bottomNavBarSetup = findViewById<BottomAppBar>(R.id.bar)
        bottomNavBarSetup?.setupWithNavController(navController)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.homeFragmentMenuItem -> findNavController(R.id.my_nav_host_fragment).navigate(R.id.homeFragment)
            R.id.userDataFragmentMenuItem -> findNavController(R.id.my_nav_host_fragment).navigate(R.id.userDataFragment)
        }
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.my_nav_host_fragment).navigateUp(appBarConfiguration)
    }

    fun setupBottomActionBar() {

    }
}
