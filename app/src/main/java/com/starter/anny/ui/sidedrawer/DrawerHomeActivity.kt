package com.starter.anny.ui.sidedrawer

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.starter.anny.R
import com.starter.anny.databinding.ActivityDrawerHomeBinding
import com.starter.anny.ui.base.BaseBindingActivity
import com.starter.anny.ui.utils.Boast
import com.starter.anny.ui.utils.app.AppUtils
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_drawer_home.*
import kotlinx.coroutines.launch

class DrawerHomeActivity : BaseBindingActivity<ActivityDrawerHomeBinding>(), View.OnClickListener,
    NavigationView.OnNavigationItemSelectedListener {
    override val contentView: Int
        get() = R.layout.activity_drawer_home

    private lateinit var navController: NavController

    override fun viewModelSetUp() {}

    override fun viewSetUp() {
        AppUtils.setTransparentStatusColor(this, false, R.color.orange)
        lifecycleScope.launch {
            setSupportActionBar(toolBar)
        }
        initBottomNav()
        SideNavDrawer.setNavigationItemSelectedListener(this)
        imgHamburger.setOnClickListener(this)
    }

    private fun initBottomNav() {
        navController = Navigation.findNavController(this, R.id.fragment)
        bottomNaviagtion.setupWithNavController(navController)
    }

    override fun createSavedInstanceState(savedInstanceState: Bundle?) {
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.imgHamburger -> {
                hamburger()
            }
        }
    }

    private fun hamburger() {
        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END)
        } else {
            drawer.openDrawer(GravityCompat.END)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        closeDrawer()
        when (item.itemId) {
            R.id.activity1 -> Boast.makeText(this, "activity clicked", Toast.LENGTH_SHORT)
                .show()
            R.id.logout -> {
                finish()
            }
        }
        return true
    }

    private fun closeDrawer() {
        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END)
        }
    }


}