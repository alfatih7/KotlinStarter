package com.alfatih.kotlinstarter.unitone.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alfatih.kotlinstarter.R
import com.alfatih.kotlinstarter.databinding.FragmentSpecifyAmountBinding
import com.google.android.material.textfield.TextInputEditText


class SpecifyAmountFragment : Fragment() {
    private lateinit var binding: FragmentSpecifyAmountBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_specify_amount,
            container, false
        )
        binding.sendBtn.setOnClickListener { checkBalane() }
        binding.cancelBtn.setOnClickListener {
            requireActivity().onBackPressed()

        }
        return binding.root
    }

    private fun checkBalane(
        e: TextInputEditText? = requireView().findViewById(R.id.input_amount)
    ) {
        if (e?.text!!.isEmpty()) {
            showToast("please enter the amount!")
        } else {
            var money = e.text.toString().toInt()
            val arg = SpecifyAmountFragmentArgs.fromBundle(requireArguments())
            var resName = arg.recName

            findNavController().navigate(
                SpecifyAmountFragmentDirections
                    .actionSpecifyAmountFragmentToConfirmationFragment(resName, money)
            )
        }
    }

    private fun showToast(s: String) {
        Toast.makeText(
            context, s,
            Toast.LENGTH_SHORT
        ).show()
    }
}