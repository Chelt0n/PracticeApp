package com.example.practiceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.fragment.app.Fragment
import com.example.practiceapp.databinding.ActivityMainBinding
import com.example.practiceapp.calculate.CalculateFragment
import com.example.practiceapp.note.NoteMainActivity
import com.example.practiceapp.settings.FontTypes
import com.example.practiceapp.settings.SettingsFragment
import com.example.practiceapp.settings.SharedPref
import com.example.practiceapp.settings.ThemeModes


class MainActivity : AppCompatActivity() {
    private lateinit var sharedPref: SharedPref
    private lateinit var binding: ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        sharedPref = SharedPref(getSharedPreferences(SharedPref.SETTINGS_SP, MODE_PRIVATE))
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toggle = ActionBarDrawerToggle(this,
            binding.drawerLayout,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()



        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_calculate -> {
                    setFragment(CalculateFragment.newInstance())
                    true
                }
                R.id.nav_settings -> {
                    setFragment(SettingsFragment.newInstance())
                    true
                }
                R.id.nav_general -> {
                    setFragment(GeneralFragment.newInstance())
                    true
                }
                R.id.nav_note -> {
                    val intent = Intent(this, NoteMainActivity::class.java)
                    startActivity(intent)
                    true
                }
                else ->
                    false
            }
        }
        if (savedInstanceState == null) {
            binding.navView.setCheckedItem(R.id.nav_general)
            setFragment(GeneralFragment.newInstance())
        }

    }

    override fun onResume() {
        super.onResume()
        setMode()
    }

    fun setFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment).addToBackStack("")
            .commit()
    }


    fun setMode() {
        when (sharedPref.getThemeMode()) {
            ThemeModes.DAY -> AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
            ThemeModes.NIGHT -> AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
        }
        when (sharedPref.getFontType()) {
            FontTypes.CURSIVE -> setTheme(R.style.cursive)
            FontTypes.SANS_SERIF_THIN -> setTheme(R.style.sans_serif)
            FontTypes.CONDENSED -> setTheme(R.style.condensed)
        }

    }


}