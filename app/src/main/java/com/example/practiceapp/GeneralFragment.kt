package com.example.practiceapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.practiceapp.calculate.CalculateFragment
import com.example.practiceapp.databinding.GeneralActivityBinding
import com.example.practiceapp.note.NoteMainActivity
import com.example.practiceapp.settings.SettingsFragment

class GeneralFragment : Fragment(), View.OnClickListener {
    var binding: GeneralActivityBinding? = null

    companion object {
        fun newInstance() = GeneralFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = GeneralActivityBinding.inflate(inflater, container, false)
        binding?.settings?.setOnClickListener(this)
        binding?.note?.setOnClickListener(this)
        binding?.calculate?.setOnClickListener(this)
        return binding?.root


    }

    override fun onClick(v: View?) {
        when (v) {
            binding?.settings -> setFragment(SettingsFragment.newInstance())
            binding?.calculate -> setFragment(CalculateFragment.newInstance())
            binding?.note -> {
                val intent = Intent(context, NoteMainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    fun setFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment).addToBackStack("")
            .commit()
    }

}