package com.ensoft.ussd.fragments.internet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.ensoft.ussd.FirstFragment
import com.ensoft.ussd.FourthFragment
import com.ensoft.ussd.R
import com.ensoft.ussd.SecondFragment
import com.ensoft.ussd.ThirdFragment
import com.ensoft.ussd.view_pager_adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout


class InternetFragment : Fragment() {

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_internet, container, false)

        tabLayout = view.findViewById(R.id.tabLayout)
        viewPager = view.findViewById(R.id.viewPager)


        val adapter = ViewPagerAdapter(parentFragmentManager)
        adapter.addFragment(FirstFragment(),"Kun")
        adapter.addFragment(SecondFragment(),"Hafta")
        adapter.addFragment(ThirdFragment(),"Oy")
        adapter.addFragment(FourthFragment(),"Yil")

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
        setMarginOnTabItems()

        return view
    }
    private fun setMarginOnTabItems(){
        for (i in 0 until tabLayout.tabCount){
            val tabItem = (tabLayout.getChildAt(0) as ViewGroup).getChildAt(i)
            val params = tabItem.layoutParams as ViewGroup.MarginLayoutParams
            params.setMargins(15,15,15,0)
        }
    }

}