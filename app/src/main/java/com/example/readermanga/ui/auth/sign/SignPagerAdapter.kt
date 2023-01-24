package com.example.readermanga.ui.auth.sign

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SignPagerAdapter(private val fragments: List<Fragment>, fm: FragmentActivity) :
    FragmentStateAdapter(fm) {

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return fragments[0]
            1 -> return fragments[1]
        }
        return fragments[0]
    }
}