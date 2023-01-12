package com.diakonov.testcountry.screens.detailed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.diakonov.testcountry.databinding.FragmentDetailedInfoBinding
import com.squareup.picasso.Picasso

class DetailedInfoFragment : Fragment() {
    lateinit var binding: FragmentDetailedInfoBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailedInfoBinding.inflate(inflater)

        binding.tvTimeInf.text = arguments?.getString("zones")
        binding.tvCapInf.text = arguments?.getString("cap")
        binding.tvCurrInf.text = arguments?.getString("currencies")
        binding.tvRegInf.text = arguments?.getString("region")
        binding.tvCountName.text = arguments?.getString("name")
        Picasso.get().load(arguments?.getString("flag")).into(binding.imCountFlag)
        return binding.root
    }

}