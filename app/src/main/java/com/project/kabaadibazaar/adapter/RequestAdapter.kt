package com.project.kabaadibazaar.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.project.kabaadibazaar.fragment.CancelledFragment
import com.project.kabaadibazaar.fragment.CompletedFragment
import com.project.kabaadibazaar.fragment.PendingFragment


class RequestAdapter(fm: FragmentManager?, var totalTabs: Int) : FragmentPagerAdapter(fm!!) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                PendingFragment()
            }
            1 -> {
                CompletedFragment()
            }
            2 -> {
                CancelledFragment()
            }
            else -> null
        }!!
    }

    override fun getCount(): Int {
        return totalTabs
    }

}