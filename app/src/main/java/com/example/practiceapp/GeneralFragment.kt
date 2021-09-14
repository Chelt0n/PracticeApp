package com.example.practiceapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.practiceapp.databinding.GeneralActivityBinding

class GeneralFragment:Fragment() {
    var binding: GeneralActivityBinding? = null

    companion object{
        fun newInstance() = GeneralFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = GeneralActivityBinding.inflate(inflater, container, false)
        return binding?.root
    }

}