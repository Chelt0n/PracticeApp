package com.example.practiceapp


import android.content.Context
import android.content.SharedPreferences
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.fragment.app.Fragment

import com.example.practiceapp.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {
    private lateinit var sharedPref: SharedPref
    private var binding: FragmentSettingsBinding? = null


    companion object {
        fun newInstance() = SettingsFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        sharedPref = SharedPref(requireActivity().getSharedPreferences(SharedPref.SETTINGS_SP,
            Context.MODE_PRIVATE))
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        binding?.switchTheme?.isChecked = sharedPref.getThemeMode() == ThemeModes.NIGHT
        binding?.saveSettings?.setOnClickListener {
            if (binding?.switchTheme?.isChecked == true) {
                sharedPref.setThemeMode(ThemeModes.NIGHT)
            } else {
                sharedPref.setThemeMode(ThemeModes.DAY)
            }
            when (binding?.radioGroup?.checkedRadioButtonId) {
                R.id.radio1 -> sharedPref.setFontType(FontTypes.CURSIVE)
                R.id.radio2 -> sharedPref.setFontType(FontTypes.SANS_SERIF_THIN)
                R.id.radio3 -> sharedPref.setFontType(FontTypes.CONDENSED)
            }
            (requireActivity() as MainActivity).setMode()
            (requireActivity() as MainActivity).setFragment(newInstance())


        }
        when (sharedPref.getFontType()) {
            FontTypes.CURSIVE -> binding?.radioGroup?.check(R.id.radio1)
            FontTypes.SANS_SERIF_THIN -> binding?.radioGroup?.check(R.id.radio2)
            FontTypes.CONDENSED -> binding?.radioGroup?.check(R.id.radio3)
        }


        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }


}