package com.example.practiceapp

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.practiceapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getSharedPreference()) {
            setTheme(R.style.whiteTheme)
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId){
                R.id.nav_calculate ->{
                    setFragment(CalculateFragment.newInstance())
                    true
                }
                    R.id.nav_settings ->{
                        setFragment(SettingsFragment.newInstance())
                    true
                }
                else -> false
            }
        }
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
    private fun getSharedPreference(): Boolean {
        sharedPreferences = getSharedPreferences(Settings.SETTINGS_SP, Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean(Settings.KEY_CURRENT_THEME, Settings.CHECK)
    }

}