package com.example.practiceapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.practiceapp.databinding.FragmentCalculateBinding

class CalculateFragment : Fragment(), View.OnClickListener {
    private var num = ""
    private var firstCount = ""
    private var secondCount = 0
    private var operand: Char = '\u0000'
    private var _binding: FragmentCalculateBinding? = null
    private val binding: FragmentCalculateBinding
        get() {
            return _binding!!
        }

    companion object {
        fun newInstance() = CalculateFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalculateBinding.inflate(layoutInflater, container, false)
        initButton()
        return binding.root
    }

    private fun initButton() {
        binding.zero.setOnClickListener(this)
        binding.one.setOnClickListener(this)
        binding.two.setOnClickListener(this)
        binding.three.setOnClickListener(this)
        binding.four.setOnClickListener(this)
        binding.five.setOnClickListener(this)
        binding.six.setOnClickListener(this)
        binding.seven.setOnClickListener(this)
        binding.eight.setOnClickListener(this)
        binding.nine.setOnClickListener(this)
        binding.delete.setOnClickListener(this)
        binding.plus.setOnClickListener(this)
        binding.equal.setOnClickListener(this)
        binding.minus.setOnClickListener(this)
        binding.divide.setOnClickListener(this)
        binding.multiply.setOnClickListener(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.one -> {
                num += "1"
                binding.textView.text = num
            }
            binding.two -> {
                num += "2"
                binding.textView.text = num
            }
            binding.three -> {
                num += "3"
                binding.textView.text = num
            }
            binding.four -> {
                num += "4"
                binding.textView.text = num
            }
            binding.five -> {
                num += "5"
                binding.textView.text = num
            }
            binding.six -> {
                num += "6"
                binding.textView.text = num
            }
            binding.seven -> {
                num += "7"
                binding.textView.text = num
            }
            binding.eight -> {
                num += "8"
                binding.textView.text = num
            }
            binding.nine -> {
                num += "9"
                binding.textView.text = num
            }
            binding.zero -> {
                if (num == "")
                    binding.textView.text = num
                else {
                    num += "0"
                    binding.textView.text = num
                }
            }
            binding.delete -> {
                num = ""
                binding.textView.text = num
            }
            binding.plus -> {
                firstCount = binding.textView.text.toString()
                num = ""
                operand = '+'
                binding.textView.text = num
            }
            binding.minus -> {
                firstCount = binding.textView.text.toString()
                num = ""
                operand = '-'
                binding.textView.text = num
            }
            binding.divide -> {
                firstCount = binding.textView.text.toString()
                num = ""
                operand = '/'
                binding.textView.text = num
            }
            binding.multiply -> {
                firstCount = binding.textView.text.toString()
                num = ""
                operand = '*'
                binding.textView.text = num
            }
            binding.equal -> {
                secondCount = when (operand) {
                    '+' -> firstCount.toInt() + num.toInt()
                    '-' -> firstCount.toInt() - num.toInt()
                    '/' -> firstCount.toInt() / num.toInt()
                    '*' -> firstCount.toInt() * num.toInt()
                    else -> 0
                }
                binding.textView.text = secondCount.toString()
                firstCount = binding.textView.text.toString()
            }

        }
    }

}