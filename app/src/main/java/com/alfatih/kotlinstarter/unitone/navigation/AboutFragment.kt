package com.alfatih.kotlinstarter.unitone.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.alfatih.kotlinstarter.R
import com.alfatih.kotlinstarter.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentAboutBinding>(
            inflater, R.layout.fragment_about,
            container, false
        )
        return binding.root
    }
}