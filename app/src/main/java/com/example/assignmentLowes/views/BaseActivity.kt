package com.example.assignmentLowes.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.assignmentLowes.R
import com.example.assignmentLowes.utils.DataViewModelFactory
import com.example.assignmentLowes.views.viewModel.BaseViewModel


class BaseActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var baseViewModel: BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        val dataViewModelFactory = DataViewModelFactory(this)
        baseViewModel = ViewModelProviders.of(this, dataViewModelFactory).get(BaseViewModel::class.java)

        NavigationUI.setupActionBarWithNavController(this, navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}