package com.example.practiceapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.practiceapp.databinding.FragmentCalculateBinding

class CalculateFragment : Fragment(), View.OnClickListener {
    private var num = StringBuilder()
    private var firstCount = ""
    private var finalCount = 0
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
    ): View {
        _binding = FragmentCalculateBinding.inflate(inflater, container, false)
        initButton()
        if (savedInstanceState != null) {
            binding.textView.text = savedInstanceState.get("CALC").toString()
        }

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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("CALC", binding.textView.text.toString())
    }


    override fun onClick(v: View?) {
        when (v) {
            binding.one -> {
                binding.textView.text = num.append(1)
            }
            binding.two -> {
                binding.textView.text = num.append(2)
            }
            binding.three -> {
                binding.textView.text = num.append(3)
            }
            binding.four -> {
                binding.textView.text = num.append(4)
            }
            binding.five -> {
                binding.textView.text = num.append(5)
            }
            binding.six -> {
                binding.textView.text = num.append(6)
            }
            binding.seven -> {
                binding.textView.text = num.append(7)
            }
            binding.eight -> {
                binding.textView.text = num.append(8)
            }
            binding.nine -> {
                binding.textView.text = num.append(9)
            }
            binding.zero -> {
                if (num.isEmpty())
                    binding.textView.text = ""
                else {
                    binding.textView.text = num.append(0)
                }
            }
            binding.delete -> {
                num.setLength(0)
                binding.textView.text = num
            }
            binding.plus -> {
                firstCount = binding.textView.text.toString()
                num.setLength(0)
                operand = '+'
                binding.textView.text = num
            }
            binding.minus -> {
                firstCount = binding.textView.text.toString()
                num.setLength(0)
                operand = '-'
                binding.textView.text = num
            }
            binding.divide -> {
                firstCount = binding.textView.text.toString()
                num.setLength(0)
                operand = '/'
                binding.textView.text = num
            }
            binding.multiply -> {
                firstCount = binding.textView.text.toString()
                num.setLength(0)
                operand = '*'
                binding.textView.text = num
            }
            binding.equal -> {
                finalCount = when (operand) {
                    '+' -> firstCount.toInt() + Integer.parseInt(num.toString())
                    '-' -> firstCount.toInt() - Integer.parseInt(num.toString())
                    '/' -> firstCount.toInt() / Integer.parseInt(num.toString())
                    '*' -> firstCount.toInt() * Integer.parseInt(num.toString())
                    else -> 0
                }
                binding.textView.text = finalCount.toString()
            }
        }
    }
}
