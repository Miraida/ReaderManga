package com.example.readermanga.ui.auth.sign

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.core.common.Constants
import com.example.readermanga.R
import com.example.readermanga.ui.auth.sign_in.SignInFragment
import com.example.readermanga.ui.auth.sign_up.SignUpFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class SignFragment : Fragment(R.layout.fragment_sign) {

    private lateinit var pager: ViewPager2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init(view)
        checkArguments()
    }

    private fun checkArguments() {
        arguments?.let {
            it.getString(Constants.SIGN_KEY)?.let { number ->
                changeCurrentItem(number.toInt())
            }
        }
    }

    private fun init(view: View) {
        val fragments =
            listOf(SignInFragment(this::changeCurrentItem), SignUpFragment(this::changeCurrentItem))
        val adapter = SignPagerAdapter(fragments = fragments, requireActivity())

        pager = view.findViewById(R.id.signViewPager)
        val tabLayout = view.findViewById<TabLayout>(R.id.signTab)
        pager.adapter = adapter

        TabLayoutMediator(tabLayout, pager) { tab: TabLayout.Tab, i: Int ->
            when (i) {
                0 -> tab.text = getString(R.string.title_sign_in)
                1 -> tab.text = getString(R.string.title_sign_up)
            }
        }.attach()
    }

    private fun changeCurrentItem(pos: Int) {
        pager.setCurrentItem(pos, false)
    }
}