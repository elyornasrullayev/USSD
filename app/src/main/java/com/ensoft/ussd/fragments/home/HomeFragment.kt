package com.ensoft.ussd.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ensoft.ussd.R
import com.ensoft.ussd.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentHomeBinding.inflate(inflater, container, false)

        binding.imgUssd.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_ussdFragment)
        }
        binding.imgInternet.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_internetFragment)
        }
        binding.imgMinut.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_minuteFragment)
        }
        binding.imgSms.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_smsFragment)
        }
        binding.imgTarif.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_tariffFragment)
        }
        binding.imgXizmat.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_serviceFragment)
        }


        return binding.root
    }

}