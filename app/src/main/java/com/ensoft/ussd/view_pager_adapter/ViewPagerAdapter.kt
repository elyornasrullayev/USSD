package com.ensoft.ussd.view_pager_adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ensoft.ussd.FirstFragment
import com.ensoft.ussd.FourthFragment
import com.ensoft.ussd.SecondFragment
import com.ensoft.ussd.ThirdFragment

class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    val fragments:MutableList<Fragment> = ArrayList()
    val titles:MutableList<String> = ArrayList()

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return FirstFragment()
            1 -> return SecondFragment()
            2 -> return ThirdFragment()
            3 -> return FourthFragment()
        }
        return FirstFragment()
    }
    fun addFragment(fragment: Fragment, title: String){
        fragments.add(fragment)
        titles.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position].lowercase()
    }
}