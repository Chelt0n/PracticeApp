package com.example.practiceapp

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.core.app.ActivityCompat.recreate
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.practiceapp.databinding.FragmentSettingsBinding
import android.os.Build
import android.content.Intent.getIntent

import android.content.Intent







class SettingsFragment : Fragment(), CompoundButton.OnCheckedChangeListener {
    private lateinit var sharedPreferences: SharedPreferences
    private var _binding: FragmentSettingsBinding? = null
    private val binding: FragmentSettingsBinding
        get() {
            return _binding!!
        }

    companion object {
        fun newInstance() = SettingsFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        binding.switchTheme?.setOnCheckedChangeListener(this)
        binding.switchTheme?.isChecked = getSharedPreference()
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        if (isChecked) {
            Settings.CHECK = true
            saveSharedPreference(Settings.CHECK)
            binding.text1!!.text = "Право"



        } else {
            Settings.CHECK = false
            saveSharedPreference(Settings.CHECK)
            binding.text1!!.text = "Лево"

        }

    }

    private fun saveSharedPreference(isChecked: Boolean) {
        sharedPreferences =
            requireActivity().getSharedPreferences(Settings.SETTINGS_SP, Context.MODE_PRIVATE)
        sharedPreferences.edit().putBoolean(Settings.KEY_CURRENT_THEME, isChecked).apply()

    }

    private fun getSharedPreference(): Boolean {
        sharedPreferences =
            requireActivity().getSharedPreferences(Settings.SETTINGS_SP, Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean(Settings.KEY_CURRENT_THEME, Settings.CHECK)
    }


}