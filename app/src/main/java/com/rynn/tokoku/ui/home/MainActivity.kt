package com.rynn.tokoku.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.rynn.tokoku.R
import com.rynn.tokoku.databinding.ActivityMainBinding
import com.rynn.tokoku.ui.auth.TokokuAuth
import com.rynn.tokoku.ui.auth.AuthActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        init()
    }

    private fun init() {
        binding.bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.ic_home->navigate(R.id.homeFragment)
                R.id.ic_news->navigate(R.id.newsFragment)
                R.id.ic_favorit->navigate(R.id.favoriteFragment)
                R.id.ic_profile->navigate(R.id.profileFragment)
                else -> false
            }
        }
    }

    private fun navigate(id: Int): Boolean {
        findNavController(R.id.navHost).navigate(id)
        return true
    }
}