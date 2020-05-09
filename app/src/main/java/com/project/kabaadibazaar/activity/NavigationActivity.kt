package com.project.kabaadibazaar.activity

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.project.kabaadibazaar.R
import com.project.kabaadibazaar.fragment.AccountFragment
import com.project.kabaadibazaar.fragment.HomaFragment
import com.project.kabaadibazaar.fragment.RequestFragment
import com.project.kabaadibazaar.fragment.WalletFragment

class NavigationActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val navViewBottom: BottomNavigationView = findViewById(R.id.nav_supplier_view)

        navViewBottom.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        setFragment(HomaFragment.newInstance("home", "data"))

    }

    private val onNavigationItemSelectedListener =
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.navigation_supplier_home -> {
                        setFragment(HomaFragment.newInstance("home", ""))
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.navigation_supplier_request -> {
                        setFragment(RequestFragment.newInstance("request", ""))
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.navigation_supplier_wallet -> {
                        setFragment(WalletFragment.newInstance("wallet", ""))
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.navigation_supplier_account -> {
                        setFragment(AccountFragment.newInstance("account", ""))
                        return@OnNavigationItemSelectedListener true
                    }
                }
                false
            }

    private fun setFragment(fragment: Fragment) {
        val t = supportFragmentManager.beginTransaction()
        t.replace(R.id.nav_supplier_host_fragment, fragment)
        t.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.navigation, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
